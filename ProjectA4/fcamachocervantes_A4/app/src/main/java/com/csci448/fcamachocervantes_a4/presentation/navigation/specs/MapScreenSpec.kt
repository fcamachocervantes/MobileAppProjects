package com.csci448.fcamachocervantes_a4.presentation.navigation.specs

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import com.csci448.fcamachocervantes_a4.R
import com.csci448.fcamachocervantes_a4.data.MarkerItem
import com.csci448.fcamachocervantes_a4.presentation.map.MapScreen
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.CoroutineScope
import java.sql.Timestamp

object MapScreenSpec: IScreenSpec {
    private const val LOG_TAG = "448.MapScreenSpec"

    override val route = "map"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route
    override val title = R.string.app_name

    @Composable
    override fun Content(
        weatherViewModel: WeatherViewModel,
        context: Context,
        coroutineScope: CoroutineScope
    ) {
        Log.d(MapScreenSpec.LOG_TAG, "MapScreenSpec Displaying")
        MapScreen(
            weatherViewModel = weatherViewModel,
            onGetLocation = {
                Log.d("448.MapScreenSpec", "onGetLocation")
                weatherViewModel.mLocationUtility.checkPermissionAndGetLocation(weatherViewModel.mActivity,
                    weatherViewModel.mLocationPermissionLauncher)

                val location = weatherViewModel.currentLocation.value
                val address = weatherViewModel.currentAddress.value
                val timestamp = Timestamp(System.currentTimeMillis()).toString()

                if(location != null && address != null && weatherViewModel.saveLocations.value) {
                    weatherViewModel.addMarker(
                        MarkerItem(
                            latitude = location.latitude,
                            longitude = location.longitude,
                            address = address,
                            snippet = "${location.latitude} / ${location.longitude}",
                            timestamp = timestamp
                        )
                    )

                    Toast.makeText(context, "Lat/Lng: (${location.latitude}, ${location.longitude}) \nYou were here: ${timestamp} \n", Toast.LENGTH_SHORT).show()
                }
            },
            coroutineScope = coroutineScope
        )
    }
}