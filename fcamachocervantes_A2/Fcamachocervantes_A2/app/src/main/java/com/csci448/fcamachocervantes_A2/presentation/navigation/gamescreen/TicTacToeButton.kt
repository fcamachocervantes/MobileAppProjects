package com.csci448.fcamachocervantes_A2.presentation.navigation.gamescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A2.R

@Composable
fun TicTacToeButton(
    imageId: Int = R.drawable.blank,
    imageDescId: Int = R.string.blank_tile
){
    Button(
        onClick = { },
        modifier = Modifier
            .padding(all = 10.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = imageDescId)
        )
    }
}