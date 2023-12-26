package com.csci448.fcamachocervantes_A2.presentation.navigation.settingsscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.R

@Composable
fun SettingsCheckBoxes(
                        buttonText: String,
                        buttonChecked: Boolean = false,
                        onClick: () -> Unit
){
    //Sound effects
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(20.dp)
    ){
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .fillMaxHeight()
        ){
            Text(
                text = buttonText,
                fontSize = 30.sp
            )
        }
        IconButton(
            onClick = { onClick() },
            modifier = Modifier.size(80.dp)
        ) {
            Icon(

                imageVector = (
                                if(!buttonChecked){
                                    Icons.Filled.CheckBoxOutlineBlank
                                }
                                else {
                                    Icons.Filled.CheckBox
                                }
                        ),
                contentDescription = buttonText,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}