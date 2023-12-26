package com.csci448.fcamachocervantes_a4.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.csci448.fcamachocervantes_a4.data.MarkerItem
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface MarkerDao {
    @Insert
    fun addMarker(marker: MarkerItem)
    @Query("SELECT * FROM marker")
    fun getMarkers(): Flow<List<MarkerItem>>
    @Query("SELECT * FROM marker WHERE id=(:id)")
    suspend fun getMarkerById(id: UUID): MarkerItem?
    @Delete
    suspend fun deleteMarker(marker: MarkerItem)
    @Query("DELETE FROM marker")
    suspend fun deleteMarkers()
}