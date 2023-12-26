package com.csci448.fcamachocervantes_A2.presentation.navigation.gamescreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel
import com.csci448.fcamachocervantes_A2.R
import com.csci448.fcamachocervantes_A2.data.HistoryRepo
import com.csci448.fcamachocervantes_A2.ui.theme.Purple80


@Composable
fun GameScreen(
                gameViewModel: GameViewModel
){
    val orientation = LocalConfiguration.current.orientation

    when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            //Game Screen in Portrait
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                //Title Column
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    Text(
                        text = stringResource(id = R.string.game_screen_title),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        lineHeight = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.80f)
                        .fillMaxHeight()
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(Purple80)
                ){
                    TicTacToeScreen(gameViewModel = gameViewModel)
                }
            }
        }
        else -> {
            //Game Screen in Portrait
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                //Title Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = stringResource(id = R.string.game_screen_title),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        lineHeight = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.50f)
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(Purple80)
                ){
                    TicTacToeScreen(gameViewModel = gameViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGameScreen(){
    GameScreen(gameViewModel = GameViewModel(HistoryRepo.history))
}