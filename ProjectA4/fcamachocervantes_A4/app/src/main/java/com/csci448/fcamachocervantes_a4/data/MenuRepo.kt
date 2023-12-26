package com.csci448.fcamachocervantes_a4.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object MenuRepo {
    public val MenuItems = listOf(
        MenuItem(
            id = "map",
            title = "Map",
            contentDescription = "Map Drawer Button",
            icon = Icons.Default.LocationOn
        ),
        MenuItem(
            id = "history",
            title = "History",
            contentDescription = "History Drawer Button",
            icon = Icons.Default.Menu
        ),
        MenuItem(
            id = "settings",
            title = "Settings",
            contentDescription = "Settings Drawer Button",
            icon = Icons.Default.Settings
        ),
        MenuItem(
            id = "about",
            title = "About",
            contentDescription = "About Drawer Button",
            icon = Icons.Default.Info
        )
    )
}