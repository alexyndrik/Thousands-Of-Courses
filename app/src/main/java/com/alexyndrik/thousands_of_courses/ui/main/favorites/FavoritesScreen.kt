package com.alexyndrik.thousands_of_courses.ui.main.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.R
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseEntity

@Composable
fun FavoritesScreen(
    favoritesViewModel: FavoritesViewModel
) {
    val favorites: List<FavoriteCourseEntity> by favoritesViewModel.favorites.observeAsState(ArrayList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(com.alexyndrik.common.R.color.black))
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(56.dp))

        Text(
            text = stringResource(R.string.favorites),
            color = colorResource(com.alexyndrik.common.R.color.white),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        FavoritesSection(favorites, favoritesViewModel)

        Spacer(modifier = Modifier.height(120.dp))
    }
}