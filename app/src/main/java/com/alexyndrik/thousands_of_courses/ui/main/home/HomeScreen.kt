package com.alexyndrik.thousands_of_courses.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.data.model.Course
import com.alexyndrik.thousands_of_courses.ui.main.courses.CoursesSection
import com.alexyndrik.thousands_of_courses.ui.main.favorites.FavoritesViewModel

@Composable
fun HomeScreen(
    coursesViewModel: CoursesViewModel,
    favoritesViewModel: FavoritesViewModel
) {
    val courses: List<Course> by coursesViewModel.courses.observeAsState(ArrayList())

    LaunchedEffect(Unit) {
        coursesViewModel.loadCourses()
        favoritesViewModel.loadFavorites()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(com.alexyndrik.common.R.color.black))
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.systemBars))
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SearchBar(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            FilterButton(modifier = Modifier) {}
        }

        Row {
            Spacer(modifier = Modifier.weight(1f))
            SortButton { coursesViewModel.sortByPublishDate() }
        }

        CoursesSection(courses, favoritesViewModel)
        when {
            courses.isEmpty() -> {
                Spacer(Modifier.weight(1f))
                CircularProgressIndicator(
                    Modifier.align(Alignment.CenterHorizontally),
                    color = colorResource(com.alexyndrik.common.R.color.green)
                )
                Spacer(Modifier.weight(1f))
            }
        }

        Spacer(modifier = Modifier.height(96.dp))
        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
    }
}
