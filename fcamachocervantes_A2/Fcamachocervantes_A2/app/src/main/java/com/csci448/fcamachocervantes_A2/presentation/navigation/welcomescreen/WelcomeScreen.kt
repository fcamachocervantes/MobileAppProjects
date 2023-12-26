package com.csci448.fcamachocervantes_A2.presentation.navigation.welcomescreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.R
import com.csci448.fcamachocervantes_A2.data.HistoryRepo
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

@Composable
fun WelcomeScreen(
    gameViewModel: GameViewModel,
    onPlayClicked: () -> Unit,
    onHistoryClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onQuitClicked: () -> Unit
){
    val orientation = LocalConfiguration.current.orientation

    when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {

                //Title text
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(350.dp)
                ) {
                    Text(
                        text = stringResource(R.string.app_title),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 70.sp,
                        lineHeight = 70.sp,
                        textAlign = TextAlign.Center
                    )
                }

                //Welcome Screen buttons
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier
                        .width(250.dp)
                        .padding(top = 40.dp)
                    ) {
                        //Play button
                        WelcomeScreenButton(
                            buttonText = stringResource(id = R.string.welcome_screen_play),
                            onClicked = { onPlayClicked() }
                        )

                        //History button
                        WelcomeScreenButton(
                            buttonText = stringResource(R.string.welcome_screen_history),
                            onClicked = { onHistoryClicked() }
                        )
                    }
                    Column(modifier = Modifier
                        .width(250.dp)
                        .padding(top = 40.dp)
                    ) {
                        //Settings button
                        WelcomeScreenButton(
                            buttonText = stringResource(R.string.welcome_screen_settings),
                            onClicked = { onSettingsClicked() }
                        )

                        //Quit button
                        WelcomeScreenButton(
                            buttonText = stringResource(R.string.welcome_screen_quit),
                            onClicked = { onQuitClicked() }
                        )
                    }
                }
            }
        }
        else -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                //Title text
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .wrapContentHeight(Alignment.CenterVertically)
                        .fillMaxSize()
                        .weight(0.6f)
                ) {
                    Text(
                        text = stringResource(R.string.app_title),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 70.sp,
                        lineHeight = 70.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }

                //Welcome Screen buttons
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                ) {
                    Column(modifier = Modifier
                        .width(250.dp)
                        .padding(top = 40.dp)) {

                        //Play button
                        WelcomeScreenButton(
                            buttonText = stringResource(id = R.string.welcome_screen_play),
                            onClicked = { onPlayClicked() }
                        )

                        //History button
                        WelcomeScreenButton(
                            buttonText = stringResource(R.string.welcome_screen_history),
                            onClicked = { onHistoryClicked() }
                        )

                        //Settings button
                        WelcomeScreenButton(
                            buttonText = stringResource(R.string.welcome_screen_settings),
                            onClicked = { onSettingsClicked() }
                        )

                        //Quit button
                        WelcomeScreenButton(
                            buttonText = stringResource(R.string.welcome_screen_quit),
                            onClicked = { onQuitClicked() }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainMenuScreenPreview(){
    WelcomeScreen(gameViewModel = GameViewModel(HistoryRepo.history), {}, {}, {}, {})
}
