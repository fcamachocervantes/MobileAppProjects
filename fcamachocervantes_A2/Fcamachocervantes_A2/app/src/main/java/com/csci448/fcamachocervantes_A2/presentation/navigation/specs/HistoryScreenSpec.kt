package com.csci448.fcamachocervantes_A2.presentation.navigation.specs

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.csci448.fcamachocervantes_A2.presentation.navigation.historyscreen.HistoryScreen
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

object HistoryScreenSpec : IScreenSpec{
    private const val LOG_TAG = "448.HistoryScreen"

    override val route = "historyScreen"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route

    @Composable
    override fun Content(
        gameViewModel: GameViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    ) {
        HistoryScreen(
            gameViewModel = gameViewModel
        )
    }
}