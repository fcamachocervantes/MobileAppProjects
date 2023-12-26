package com.csci448.fcamachocervantes_a4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.csci448.fcamachocervantes_a4.presentation.drawer.WeatherDrawer
import com.csci448.fcamachocervantes_a4.presentation.map.MapScreen
import com.csci448.fcamachocervantes_a4.presentation.navigation.WeatherNavHost
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModelFactory
import com.csci448.fcamachocervantes_a4.ui.theme.Fcamachocervantes_A4Theme
import com.csci448.fcamachocervantes_a4.util.LocationUtility
import com.google.android.gms.location.LocationSettingsStates

class MainActivity : ComponentActivity() {

    private lateinit var locationUtility: LocationUtility
    private lateinit var locationPermissionLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var locationLauncher: ActivityResultLauncher<IntentSenderRequest>
    private lateinit var mWeatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = WeatherViewModelFactory(this)
        mWeatherViewModel = ViewModelProvider(this, factory)[factory.getViewModelClass()]

        locationUtility = LocationUtility(this)

        locationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            locationUtility.checkPermissionAndGetLocation(this@MainActivity, locationPermissionLauncher)
        }

        locationLauncher = registerForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.let { data ->
                    val states = LocationSettingsStates.fromIntent(data)
                    locationUtility.verifyLocationSettingsStates(states)
                }
            }
        }

        setContent {
            Fcamachocervantes_A4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val locationState = locationUtility
                        .currentLocationStateFlow
                        .collectAsStateWithLifecycle(lifecycle = this@MainActivity.lifecycle)

                    val addressState = locationUtility
                        .currentAddressStateFlow
                        .collectAsStateWithLifecycle(lifecycle = this@MainActivity.lifecycle)

                    val locationAvailableState = locationUtility
                        .isLocationAvailableStateFlow
                        .collectAsStateWithLifecycle(lifecycle = this@MainActivity.lifecycle)

                    LaunchedEffect(locationState.value) {
                        locationUtility.getAddress(locationState.value)
                    }

                    LaunchedEffect(locationState.value) {
                        locationUtility.getAddress(locationState.value)
                    }

                    mWeatherViewModel.setLocation(locationState.value)
                    mWeatherViewModel.setAddress(addressState.value)
                    mWeatherViewModel.setUtils(locationUtility, locationPermissionLauncher, this@MainActivity)

                    val navController = rememberNavController()
                    val context = LocalContext.current
                    val coroutineScope = rememberCoroutineScope()

                    WeatherDrawer(
                        items = mWeatherViewModel.menuItems,
                        onItemClick = {
                            navController.navigate(it.id)
                        },
                        currentScreen = {
                            WeatherNavHost(
                                navController = navController,
                                weatherViewModel = mWeatherViewModel,
                                context = context,
                                coroutineScope = coroutineScope
                            )
                        }
                    )
                }
            }
        }
    }
}
