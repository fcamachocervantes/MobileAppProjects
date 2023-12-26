package com.csci448.fcamachocervantes_A2.presentation.navigation.settingsscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.R
import com.csci448.fcamachocervantes_A2.data.HistoryRepo
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

@Composable
fun SettingsScreen(gameViewModel: GameViewModel){
    Column(modifier = Modifier.fillMaxSize()){

        //Title Text
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .fillMaxSize()
                .weight(0.15f)
        ) {
            Text(
                text = stringResource(R.string.settings_title_text),
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 45.sp,
                lineHeight = 45.sp,
                modifier = Modifier
            )
        }

        //Settings
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.85f)
        ){
            Column(){

                //One Player Game
                SettingsCheckBoxes(
                    buttonText = stringResource(id = R.string.setting_text_1),
                    buttonChecked = gameViewModel.onePlayerGame.value,
                    onClick = { gameViewModel.updateOnePlayerGame() }
                )

                //AI Level
                SettingsCheckBoxes(
                    buttonText = stringResource(id = R.string.setting_text_2),
                    buttonChecked = gameViewModel.aiLevelHard.value,
                    onClick = { gameViewModel.updateAILevelHard() }
                )

                //X Goes First
                SettingsCheckBoxes(
                    buttonText = stringResource(id = R.string.setting_text_3),
                    buttonChecked = gameViewModel.xGoesFirst.value,
                    onClick = { gameViewModel.updateXGoesFirst() }
                )

                Button(
                    onClick = { gameViewModel.deleteHistory() },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.clear_history),
                        fontSize = 22.sp,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview(){
    SettingsScreen(gameViewModel = GameViewModel(HistoryRepo.history))
}