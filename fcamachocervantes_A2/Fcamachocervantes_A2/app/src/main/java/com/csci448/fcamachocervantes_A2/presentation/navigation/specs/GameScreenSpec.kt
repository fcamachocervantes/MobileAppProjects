package com.csci448.fcamachocervantes_A2.presentation.navigation.specs

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.csci448.fcamachocervantes_A2.presentation.navigation.gamescreen.GameScreen
import com.csci448.fcamachocervantes_A2.presentation.navigation.welcomescreen.WelcomeScreen
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

object GameScreenSpec : IScreenSpec {
    private const val LOG_TAG = "448.GameScreen"

    override val route = "gameScreen"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route

    @Composable
    override fun Content(
        gameViewModel: GameViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    ) {
        GameScreen(gameViewModel = gameViewModel)
    }
}