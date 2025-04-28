package com.alexyndrik.thousands_of_courses.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector, val selectedIcon: ImageVector = icon) {
    data object Home : Screen(route = "main", label = "Главная", icon = Icons.Default.Home)
    data object Favorites : Screen(route = "favorites", label = "Избранное", icon = Icons.Default.BookmarkBorder, selectedIcon = Icons.Default.Bookmark)
    data object Account : Screen(route = "account", label = "Аккаунт", icon = Icons.Default.PersonOutline, selectedIcon = Icons.Default.Person)
}