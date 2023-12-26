package com.csci448.fcamachocervantes_A2.presentation.navigation.historyscreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.R
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

@Composable
fun HistoryScreen(
    gameViewModel: GameViewModel
) {
    val orientation = LocalConfiguration.current.orientation
    val playerScore = gameViewModel.playerScoreState.value
    val computerScore = gameViewModel.computerScoreState.value
    val tieScore = gameViewModel.tieScoreState.value


    when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.player_wins, playerScore),
                        lineHeight = 20.sp,
                        fontSize = 20.sp
                    )
                    Text(
                        text = stringResource(id = R.string.computer_wins, computerScore),
                        lineHeight = 20.sp,
                        fontSize = 20.sp
                    )
                    Text(
                        text = stringResource(id = R.string.number_ties, tieScore),
                        lineHeight = 20.sp,
                        fontSize = 20.sp
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp)
                )

                HistoryList(gameViewModel.historyList)
            }
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.player_wins, playerScore),
                    lineHeight = 20.sp,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(id = R.string.computer_wins, computerScore),
                    lineHeight = 20.sp,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(id = R.string.number_ties, tieScore),
                    lineHeight = 20.sp,
                    fontSize = 20.sp
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )

                HistoryList(gameViewModel.historyList)
            }
        }
    }
}
