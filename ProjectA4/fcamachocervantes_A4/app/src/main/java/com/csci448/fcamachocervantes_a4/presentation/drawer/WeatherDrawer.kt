package com.csci448.fcamachocervantes_a4.presentation.drawer

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_a4.data.MenuItem
import kotlinx.coroutines.launch

@Composable
fun WeatherDrawer(items: List<MenuItem>,
                  onItemClick: (MenuItem) -> Unit,
                  //I'm passing a screen to the drawer based on which button gets clicked
                  currentScreen: @Composable () -> Unit
){
    Log.d("448.Drawer", "WeatherDrawer Drawn")

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        scrimColor = MaterialTheme.colorScheme.background,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                //this is the header for the drawer at the top above the buttons
                DrawerHeader()

                //this is creating the buttons in the drawer for each option
                LazyColumn {
                    items(items) { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onItemClick(item)
                                    coroutineScope.launch { drawerState.close() }
                                }
                                .padding(16.dp)
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.contentDescription
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = item.title,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            coroutineScope.launch { drawerState.close() }
                        }
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Drawer"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Close Drawer",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        },
        content = {
            //this is the scaffold for the banner at the top of the screen that also
            //changes it's content when a button is clicked in the drawer
            Scaffold(
                modifier = Modifier
                    .fillMaxWidth(),
                topBar = {
                    TopAppBar(
                        onNavigationIconClick = {
                            Log.d("448.Drawer", "Open Drawer Clicked")
                            coroutineScope.launch { drawerState.open() }
                        }
                    )
                }
            ) {
                //this holds the different screens
                Column(
                    modifier = Modifier
                        .padding(it)
                ) {
                    currentScreen()
                }
            }
        }
    )
}
