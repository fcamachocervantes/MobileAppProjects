package com.csci448.fcamachocervantes_a4.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.maps.android.compose.MarkerState
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "marker")
data class MarkerItem(
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val snippet: String,
    val timestamp: String,
    @PrimaryKey
    val id: UUID = UUID.randomUUID()
)
