package com.csci448.fcamachocervantes_A2.presentation.navigation.welcomescreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreenButton(
                buttonText: String,
                onClicked: () -> Unit
){
    Button(
        onClick = { onClicked() },
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Text(
            text = buttonText,
            fontSize = 22.sp,
            modifier = Modifier
        )
    }
}
