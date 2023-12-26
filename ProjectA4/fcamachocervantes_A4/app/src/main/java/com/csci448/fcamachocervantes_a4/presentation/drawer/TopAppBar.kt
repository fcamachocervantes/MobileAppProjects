package com.csci448.fcamachocervantes_a4.presentation.drawer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    onNavigationIconClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            actions = {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Top Bar Menu Icon"
                    )
                }
            },
            title = {
                Text(text = "WeathrTrackr", fontSize = 24.sp)
            }
        )
    }
}