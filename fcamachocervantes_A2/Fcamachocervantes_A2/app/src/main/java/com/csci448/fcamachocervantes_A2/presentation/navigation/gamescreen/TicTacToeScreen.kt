package com.csci448.fcamachocervantes_A2.presentation.navigation.gamescreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel
import com.csci448.fcamachocervantes_A2.ui.theme.Purple80
import com.csci448.fcamachocervantes_A2.R
import com.csci448.fcamachocervantes_A2.data.HistoryRepo

@Composable
fun TicTacToeScreen(
                    gameViewModel: GameViewModel   
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                TicTacToeButton()
                TicTacToeButton()
                TicTacToeButton()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                TicTacToeButton()
                TicTacToeButton()
                TicTacToeButton()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                TicTacToeButton()
                TicTacToeButton()
                TicTacToeButton()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewTicTacToeScreen(){
    TicTacToeScreen(gameViewModel = GameViewModel(HistoryRepo.history))
}