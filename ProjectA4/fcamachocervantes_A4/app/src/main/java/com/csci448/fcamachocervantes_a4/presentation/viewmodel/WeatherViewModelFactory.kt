package com.csci448.fcamachocervantes_a4.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.fcamachocervantes_a4.data.MarkerRepo

class WeatherViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        private const val LOG_TAG = "448.WeatherViewModelFactory"
    }

    fun getViewModelClass() = WeatherViewModel::class.java

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d(LOG_TAG, "create() called")
        if(modelClass.isAssignableFrom(getViewModelClass())) {
            Log.d(LOG_TAG, "creating ViewModel: ${getViewModelClass()}")
            return modelClass
                .getConstructor(MarkerRepo::class.java)
                .newInstance(MarkerRepo.getInstance(context))
        }
        Log.e(LOG_TAG, "Unknown ViewModel: $modelClass")
        throw IllegalArgumentException("Unknown ViewModel")
    }
}