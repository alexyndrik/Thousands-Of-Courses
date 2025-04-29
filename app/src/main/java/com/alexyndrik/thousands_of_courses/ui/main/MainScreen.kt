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
import com.alexyndrik.thousands_of_courses.R

@Composable
fun MainScreen(navController: NavController) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        containerColor = colorResource(R.color.dark_gray),
        contentColor = colorResource(R.color.green)
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
                        tint = if (currentRoute == screen.route) colorResource(R.color.green) else colorResource(R.color.white)
                    )
                },
                label = {
                    Text(
                        text = screen.label,
                        color = if (currentRoute == screen.route) colorResource(R.color.green) else colorResource(R.color.white)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = colorResource(R.color.light_gray)
                )
            )
        }
    }
}