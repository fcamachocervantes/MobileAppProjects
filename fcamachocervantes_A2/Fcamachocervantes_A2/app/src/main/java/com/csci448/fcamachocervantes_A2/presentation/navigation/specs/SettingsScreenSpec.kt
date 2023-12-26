package com.csci448.fcamachocervantes_A2.presentation.navigation.specs

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.csci448.fcamachocervantes_A2.presentation.navigation.settingsscreen.SettingsScreen
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

object SettingsScreenSpec : IScreenSpec{
    private const val LOG_TAG = "448.SettingsScreenSpec"

    override val route = "settingsScreen"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route

    @Composable
    override fun Content(
        gameViewModel: GameViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    ) {
        SettingsScreen(gameViewModel = gameViewModel)
    }
}