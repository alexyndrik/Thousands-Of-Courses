package com.alexyndrik.thousands_of_courses.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.alexyndrik.thousands_of_courses.ui.main.favorites.FavoritesViewModel
import com.alexyndrik.thousands_of_courses.ui.main.home.CoursesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    private val coursesViewModel: CoursesViewModel by viewModels()
    private val favoritesViewModel: FavoritesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEntryPoint(coursesViewModel, favoritesViewModel)
        }
    }

}