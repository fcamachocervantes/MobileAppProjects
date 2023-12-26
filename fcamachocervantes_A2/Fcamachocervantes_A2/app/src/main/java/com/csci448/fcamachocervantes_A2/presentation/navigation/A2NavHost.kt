package com.csci448.fcamachocervantes_A2.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.csci448.fcamachocervantes_A2.presentation.navigation.specs.IScreenSpec
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

@Composable
fun A2NavHost(modifier: Modifier = Modifier,
                      navController: NavHostController,
                      gameViewModel: GameViewModel,
                      context: Context
) {
    NavHost(
        modifier = modifier,
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
                    ) {navBackStackEntry ->
                        screen.Content(
                            navController = navController,
                            navBackStackEntry = navBackStackEntry,
                            gameViewModel = gameViewModel,
                            context = context
                        )
                    }
                }
            }
        }
    }
}