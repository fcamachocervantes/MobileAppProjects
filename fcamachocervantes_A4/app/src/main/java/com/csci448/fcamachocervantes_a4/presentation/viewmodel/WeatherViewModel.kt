package com.csci448.fcamachocervantes_a4.presentation.viewmodel


import android.app.Activity
import android.location.Location
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csci448.fcamachocervantes_a4.data.MarkerItem
import com.csci448.fcamachocervantes_a4.data.MarkerRepo
import com.csci448.fcamachocervantes_a4.data.MenuItem
import com.csci448.fcamachocervantes_a4.data.MenuRepo
import com.csci448.fcamachocervantes_a4.util.LocationUtility
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*


class WeatherViewModel(private val markerRepo: MarkerRepo) : ViewModel(), IWeatherViewModel{

    private val mMenuItems: MutableStateFlow<List<MarkerItem>> = MutableStateFlow(emptyList())
    private val mCurrentLocationState: MutableStateFlow<Location?> = MutableStateFlow(null)
    private val mCurrentAddressState: MutableStateFlow<String?> = MutableStateFlow("")
    private val mSaveLocations = mutableStateOf(false)

    override val menuItems = MenuRepo.MenuItems
    override val markerItemsState: StateFlow<List<MarkerItem>>
        get() = mMenuItems.asStateFlow()

    val currentLocation: StateFlow<Location?>
        get() = mCurrentLocationState.asStateFlow()

    val currentAddress: StateFlow<String?>
        get() = mCurrentAddressState.asStateFlow()

    val saveLocations: State<Boolean>
        get() = mSaveLocations

    lateinit var mLocationUtility: LocationUtility
    lateinit var mLocationPermissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var mActivity: Activity

    init {
        viewModelScope.launch {
            markerRepo.getMarkers().collect(){markerList ->
                mMenuItems.update { markerList }
            }
        }
    }

    override fun addMarker(markerItem: MarkerItem) {
        markerRepo.addMarker(markerItem)
    }

    override fun deleteMarker(markerItem: MarkerItem) {
        markerRepo.deleteMarker(markerItem)
    }

    override fun deleteMarkers() {
        markerRepo.deleteMarkers()
    }

    fun setLocation(location: Location?) {
        mCurrentLocationState.update { location }
    }

    fun setAddress(address: String?) {
        mCurrentAddressState.update { address }
    }

    fun setUtils(locationUtility: LocationUtility, locationPermissionLauncher: ActivityResultLauncher<Array<String>>, activity: Activity) {
        mLocationUtility = locationUtility
        mLocationPermissionLauncher = locationPermissionLauncher
        mActivity = activity
    }

    fun updateLocationSettings() {
        mSaveLocations.value = !(mSaveLocations.value)
    }
}