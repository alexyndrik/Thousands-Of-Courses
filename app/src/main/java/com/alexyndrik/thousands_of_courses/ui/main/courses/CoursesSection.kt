package com.alexyndrik.thousands_of_courses.ui.main.courses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.data.model.Course
import com.alexyndrik.thousands_of_courses.ui.main.favorites.FavoritesViewModel

@Composable
fun CoursesSection(
    courses: List<Course>,
    favoritesViewModel: FavoritesViewModel
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        courses.forEach { course ->
            CourseCard(course, favoritesViewModel)
        }
    }
}