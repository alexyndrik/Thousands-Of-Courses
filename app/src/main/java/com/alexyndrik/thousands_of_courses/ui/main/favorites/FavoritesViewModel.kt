package com.alexyndrik.thousands_of_courses.ui.main.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseEntity
import com.alexyndrik.thousands_of_courses.data.model.Course
import com.alexyndrik.thousands_of_courses.data.repository.FavoriteCoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteCoursesRepository: FavoriteCoursesRepository
) : ViewModel() {

    private val _favorites = MutableLiveData<List<FavoriteCourseEntity>>(emptyList())
    val favorites: LiveData<List<FavoriteCourseEntity>> = _favorites

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = favoriteCoursesRepository.getAllFavorites()
        }
    }

    fun toggleFavorite(course: Course) {
        viewModelScope.launch {
            val id = course.id
            val isFav = favoriteCoursesRepository.isFavorite(id)
            if (isFav) {
                favoriteCoursesRepository.removeFromFavorites(FavoriteCourseEntity(course))
            } else {
                favoriteCoursesRepository.addToFavorites(FavoriteCourseEntity(course))
            }
            loadFavorites()
        }
    }

    suspend fun isFavorite(course: Course): Boolean {
        return favoriteCoursesRepository.isFavorite(course.id)
    }

    fun clearFavorites() {
        viewModelScope.launch { favoriteCoursesRepository.removeAllFromFavorites() }
    }
}