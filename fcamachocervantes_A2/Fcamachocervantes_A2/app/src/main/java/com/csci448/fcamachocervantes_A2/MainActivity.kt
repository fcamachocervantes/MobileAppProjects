package com.csci448.fcamachocervantes_A2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.csci448.fcamachocervantes_A2.presentation.navigation.A2NavHost
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModelFactory
import com.csci448.fcamachocervantes_A2.ui.theme.Fcamachocervantes_A2Theme

class MainActivity : ComponentActivity() {
    companion object {
        private const val KEY_PLAYER_SCORE = "playerScore"
        private const val KEY_COMPUTER_SCORE = "computerScore"
        private const val KEY_TIE_SCORE = "tieScore"
        private const val KEY_ONE_PLAYER_GAME = "onePlayerGame"
        private const val KEY_AI_LEVEL_HARD = "aiLevelHard"
        private const val KEY_X_GOES_FIRST = "xGoesFirst"
    }

    private lateinit var mViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val initialPlayerScore = savedInstanceState?.getInt(KEY_PLAYER_SCORE, 0)?: 0
        val initialComputerScore = savedInstanceState?.getInt(KEY_COMPUTER_SCORE, 0)?: 0
        val initialTieScore = savedInstanceState?.getInt(KEY_TIE_SCORE, 0)?: 0
        val initialOnePlayerGame = savedInstanceState?.getBoolean(KEY_ONE_PLAYER_GAME, false)?: false
        val initialAILevelHard = savedInstanceState?.getBoolean(KEY_AI_LEVEL_HARD, false)?: false
        val initialXGoesFirst = savedInstanceState?.getBoolean(KEY_X_GOES_FIRST, false)?: false

        val factory = GameViewModelFactory(initialPlayerScore, initialComputerScore, initialTieScore, initialOnePlayerGame, initialAILevelHard, initialXGoesFirst)
        val mViewModel = ViewModelProvider(this, factory)[factory.getViewModelClass()]

        setContent {
            Fcamachocervantes_A2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val context = LocalContext.current
                    A2NavHost(navController = navController, gameViewModel = mViewModel, context = context)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}