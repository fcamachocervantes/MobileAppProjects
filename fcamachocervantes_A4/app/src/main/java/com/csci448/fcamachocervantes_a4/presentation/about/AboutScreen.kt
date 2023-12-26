package com.csci448.fcamachocervantes_a4.presentation.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_a4.R

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "WeathrTrackr", fontSize = 50.sp)
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = "Developed By", fontSize = 20.sp, fontWeight = FontWeight(500))
        Text(text = "Francisco Camacho", fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = "Version", fontSize = 20.sp, fontWeight = FontWeight(500))
        Text(text = "Alpha-0.0.1", fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = "About", fontSize = 20.sp, fontWeight = FontWeight(500))
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(text = stringResource(R.string.about_paragraph), fontSize = 25.sp, lineHeight = 30.sp, softWrap = true)
        }
    }
}