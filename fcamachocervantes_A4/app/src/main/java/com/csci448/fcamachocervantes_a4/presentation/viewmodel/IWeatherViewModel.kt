package com.csci448.fcamachocervantes_a4.presentation.viewmodel

import com.csci448.fcamachocervantes_a4.data.MarkerItem
import com.csci448.fcamachocervantes_a4.data.MenuItem
import kotlinx.coroutines.flow.StateFlow

interface IWeatherViewModel {
    val menuItems: List<MenuItem>
    val markerItemsState: StateFlow<List<MarkerItem>>

    fun addMarker(markerItem: MarkerItem)
    fun deleteMarker(markerItem: MarkerItem)
    fun deleteMarkers()
}