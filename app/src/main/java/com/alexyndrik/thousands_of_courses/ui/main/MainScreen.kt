package com.alexyndrik.thousands_of_courses.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainScreen(navController: NavController) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        containerColor = colorResource(com.alexyndrik.common.R.color.dark_gray),
        contentColor = colorResource(com.alexyndrik.common.R.color.green)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listOf(Screen.Home, Screen.Favorites, Screen.Account).forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == screen.route) screen.selectedIcon else screen.icon,
                        contentDescription = null,
                        tint = if (currentRoute == screen.route) colorResource(com.alexyndrik.common.R.color.green) else colorResource(com.alexyndrik.common.R.color.white)
                    )
                },
                label = {
                    Text(
                        text = screen.label,
                        color = if (currentRoute == screen.route) colorResource(com.alexyndrik.common.R.color.green) else colorResource(com.alexyndrik.common.R.color.white)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = colorResource(com.alexyndrik.common.R.color.light_gray)
                )
            )
        }
    }
}