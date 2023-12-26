package com.csci448.fcamachocervantes_a4.presentation.navigation.specs

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.CoroutineScope

sealed interface IScreenSpec{
    companion object {
        private const val LOG_TAG = "448.IScreenSpec"

        val allScreens = IScreenSpec::class.sealedSubclasses.associate {
            Log.d(LOG_TAG, "allScreens: mapping route \"${it.objectInstance?.route ?: ""}\" to object \"${it.objectInstance}\"")
            it.objectInstance?.route to it.objectInstance
        }
        const val root = "weathrtrackr"
        val startDestination = MapScreenSpec.route
    }

    val route: String
    val title: Int
    val arguments: List<NamedNavArgument>
    fun buildRoute(vararg args: String?): String

    @Composable
    fun Content(
        weatherViewModel: WeatherViewModel,
        context: Context,
        coroutineScope: CoroutineScope
    )


}