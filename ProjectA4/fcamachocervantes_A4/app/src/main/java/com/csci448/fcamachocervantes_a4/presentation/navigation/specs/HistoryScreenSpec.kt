package com.csci448.fcamachocervantes_a4.presentation.navigation.specs

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import com.csci448.fcamachocervantes_a4.R
import com.csci448.fcamachocervantes_a4.presentation.history.HistoryScreen
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.CoroutineScope

object HistoryScreenSpec : IScreenSpec {
    private const val LOG_TAG = "448.HistoryScreenSpec"

    override val route = "history"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route
    override val title = R.string.app_name

    @Composable
    override fun Content(
        weatherViewModel: WeatherViewModel,
        context: Context,
        coroutineScope: CoroutineScope
    ) {
        Log.d(HistoryScreenSpec.LOG_TAG, "HistoryScreenSpec Displaying")
        HistoryScreen(weatherViewModel = weatherViewModel)
    }
}