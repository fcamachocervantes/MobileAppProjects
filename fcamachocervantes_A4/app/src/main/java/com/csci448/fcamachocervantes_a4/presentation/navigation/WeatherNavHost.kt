package com.csci448.fcamachocervantes_a4.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.csci448.fcamachocervantes_a4.presentation.navigation.specs.IScreenSpec
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun WeatherNavHost(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
    context: Context,
    coroutineScope: CoroutineScope
) {
    NavHost(
        navController = navController,
        startDestination = IScreenSpec.root
    ) {
        navigation(
            route = IScreenSpec.root,
            startDestination = IScreenSpec.startDestination
        ) {
            IScreenSpec.allScreens.forEach { (_, screen) ->
                if(screen != null) {
                    composable(
                        route = screen.route,
                        arguments = screen.arguments
                    ) { navBackStackEntry ->
                        screen.Content(
                            weatherViewModel,
                            context,
                            coroutineScope
                        )
                    }
                }
            }
        }
    }
}