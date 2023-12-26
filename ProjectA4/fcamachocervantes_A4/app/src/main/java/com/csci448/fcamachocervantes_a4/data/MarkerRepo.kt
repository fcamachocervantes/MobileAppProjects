package com.csci448.fcamachocervantes_a4.data

import android.content.Context
import com.csci448.fcamachocervantes_a4.data.database.MarkerDao
import com.csci448.fcamachocervantes_a4.data.database.MarkerDatabase
import com.google.maps.android.compose.Marker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.*

class MarkerRepo @OptIn(DelicateCoroutinesApi::class)
private constructor(private val markerDao: MarkerDao, private val coroutineScope: CoroutineScope = GlobalScope) {
    companion object{
        private const val LOG_TAG = "448.MarkerRepo"
        @Volatile private var INSTANCE: MarkerRepo? = null

        fun getInstance(context: Context): MarkerRepo {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    val database = MarkerDatabase.getInstance(context)
                    instance = MarkerRepo(database.markerDao)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    fun addMarker(marker: MarkerItem) {
        coroutineScope.launch {
            markerDao.addMarker(marker)
        }
    }
    fun getMarkers(): Flow<List<MarkerItem>> = markerDao.getMarkers()
    suspend fun getMarkerById(id: UUID): MarkerItem? = markerDao.getMarkerById(id)
    fun deleteMarker(marker: MarkerItem) {
        coroutineScope.launch {
            markerDao.deleteMarker(marker)
        }
    }
    fun deleteMarkers() {
        coroutineScope.launch {
            markerDao.deleteMarkers()
        }
    }
}
