package com.csci448.fcamachocervantes_A2.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.fcamachocervantes_A2.MainActivity
import com.csci448.fcamachocervantes_A2.data.HistoryRepo

class GameViewModelFactory(
    private val initialPlayerScore: Int = 0,
    private val initialComputerScore: Int = 0,
    private val initialTieScore: Int = 0,
    private val initialOnePlayerGame: Boolean = false,
    private val initialAILevelHard: Boolean = false,
    private val initialXGoesFirst: Boolean = false
) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        private const val LOG_TAG = "448.SamodelkinViewModelFactory"
    }

    fun getViewModelClass() = GameViewModel::class.java

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d(LOG_TAG, "create() called")
        if(modelClass.isAssignableFrom(getViewModelClass())) {
            Log.d(LOG_TAG, "creating ViewModel: ${getViewModelClass()}")
            return modelClass
                .getConstructor(List::class.java, Int::class.java, Int::class.java, Int::class.java, Boolean::class.java, Boolean::class.java, Boolean::class.java)
                .newInstance(HistoryRepo.history, initialPlayerScore, initialComputerScore, initialTieScore, initialOnePlayerGame, initialAILevelHard, initialXGoesFirst)
        }
        Log.e(LOG_TAG, "Unknown ViewModel: $modelClass")
        throw IllegalArgumentException("Unknown ViewModel")
    }
}