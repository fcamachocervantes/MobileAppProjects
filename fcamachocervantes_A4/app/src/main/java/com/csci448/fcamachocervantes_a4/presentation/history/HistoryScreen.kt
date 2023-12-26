package com.csci448.fcamachocervantes_a4.presentation.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(
    weatherViewModel: WeatherViewModel
) {
    LazyColumn {
        items(weatherViewModel.markerItemsState.value) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Checked In: ${item.timestamp}")
                Text("Latitude: ${item.latitude}")
                Text("Longitude: ${item.longitude}")
                Text("Address: ${item.address}")
            }
        }
    }
}