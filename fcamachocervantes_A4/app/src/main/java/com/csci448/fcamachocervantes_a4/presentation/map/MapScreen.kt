package com.csci448.fcamachocervantes_a4.presentation.map

import android.location.Location
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_a4.R
import com.csci448.fcamachocervantes_a4.data.MarkerItem
import com.csci448.fcamachocervantes_a4.presentation.navigation.specs.MapScreenSpec
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    weatherViewModel: WeatherViewModel,
    onGetLocation: () -> Unit,
    coroutineScope: CoroutineScope
) {

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(0.0, 0.0), 0f)
    }

    val mapReadyState = remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val location = weatherViewModel.currentLocation.value
    val address = weatherViewModel.currentAddress.value

    val context = LocalContext.current
    LaunchedEffect(location, mapReadyState.value) {
        if (location != null) {
            val bounds = LatLngBounds.Builder()
                .include(LatLng(location.latitude, location.longitude))
                .build()
            val padding = context.resources
                .getDimensionPixelSize(R.dimen.map_inset_padding)
            val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
            cameraPositionState.animate(cameraUpdate)
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onGetLocation,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Filled.LocationOn, "My Location Button")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { it ->
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = MapUiSettings(zoomControlsEnabled = false, compassEnabled = true),
            onMapLoaded = { mapReadyState.value = true }
        ) {
            if(!weatherViewModel.saveLocations.value) {
                if(location != null) {
                    val markerState = MarkerState().apply {
                        position = LatLng(location.latitude, location.longitude)
                    }
                    Marker(
                        state = markerState,
                        title = address,
                        snippet = "${location.latitude} / ${location.longitude}"
                    )
                }
            }
            //drawing markers to map
            weatherViewModel.markerItemsState.collectAsState().value.forEach { item ->
                val markerState = MarkerState().apply {
                    position = LatLng(item.latitude, item.longitude)
                }
                Marker(
                    state = markerState,
                    title = item.address,
                    snippet = item.snippet,
                    onInfoWindowClick = {
                        coroutineScope.launch {
                            val snackbarResult = snackbarHostState.showSnackbar(
                                message = "You were here: ${item.timestamp}",
                                duration = SnackbarDuration.Short,
                                actionLabel = "Dismiss"
                            )
                        }
                    }
                )
            }
        }
    }
}