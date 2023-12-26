package com.csci448.fcamachocervantes_a4.data.database

import android.content.Context
import androidx.room.*
import com.csci448.fcamachocervantes_a4.data.MarkerItem

@Database(entities=[MarkerItem::class], version = 1)
abstract class MarkerDatabase : RoomDatabase(){

    companion object {
        @Volatile private  var INSTANCE: MarkerDatabase? = null
        fun getInstance(context: Context): MarkerDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context = context,
                        klass = MarkerDatabase::class.java,
                        name = "marker-database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    abstract val markerDao: MarkerDao
}