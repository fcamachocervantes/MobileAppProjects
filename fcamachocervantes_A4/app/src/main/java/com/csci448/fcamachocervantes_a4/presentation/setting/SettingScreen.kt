package com.csci448.fcamachocervantes_a4.presentation.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_a4.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SettingScreen(
    weatherViewModel: WeatherViewModel,
    coroutineScope: CoroutineScope
) {
    val dialogVisibleState = remember { mutableStateOf(false) }

    if(dialogVisibleState.value) {
        AlertDialog(
            onDismissRequest = {dialogVisibleState.value = false},
            confirmButton = {
                TextButton(
                    onClick = {
                        dialogVisibleState.value = false
                        weatherViewModel.deleteMarkers()
                    }
                ){
                    Text( text = "Yes" )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        dialogVisibleState.value = false
                    }
                ) {
                    Text(text = "No")
                }
            },
            title = { Text(text = "Delete Database") },
            text = { Text(text = "Are you sure you want to delete all history from the database?") }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //switch button for choosing to save locations to database or not
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Save locations to database"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Save locations to database",
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Switch(checked = weatherViewModel.saveLocations.value, onCheckedChange = { weatherViewModel.updateLocationSettings() } )
        }
        //button for deleting entire database
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    dialogVisibleState.value = true
                }
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Database"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Delete Database",
                modifier = Modifier.weight(1f)
            )
        }
    }
}