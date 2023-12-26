package com.csci448.fcamachocervantes_A2.presentation.navigation.specs

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.csci448.fcamachocervantes_A2.presentation.navigation.welcomescreen.WelcomeScreen
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

object WelcomeScreenSpec: IScreenSpec {
    private const val LOG_TAG = "448.WelcomeScreen"

    override val route = "welcomeScreen"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route

    @Composable
    override fun Content(
        gameViewModel: GameViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    ) {
        val activity = (LocalContext.current as? Activity)
        WelcomeScreen(
            gameViewModel = gameViewModel,
            onPlayClicked = { navController.navigate(GameScreenSpec.route ) },
            onHistoryClicked = { navController.navigate( HistoryScreenSpec.route ) },
            onSettingsClicked = { navController.navigate( SettingsScreenSpec.route )},
            onQuitClicked = { activity?.finish() }
        )
    }
}