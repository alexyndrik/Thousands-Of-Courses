package com.alexyndrik.thousands_of_courses.ui.main.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseDao
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseEntity
import com.alexyndrik.thousands_of_courses.data.model.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoritesDao: FavoriteCourseDao
) : ViewModel() {

    private val _favorites = MutableLiveData<List<FavoriteCourseEntity>>(emptyList())
    val favorites: LiveData<List<FavoriteCourseEntity>> = _favorites

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = favoritesDao.getAllFavorites()
        }
    }

    fun toggleFavorite(course: Course) {
        viewModelScope.launch {
            val id = course.id
            val isFav = favoritesDao.isFavorite(id)
            if (isFav) {
                favoritesDao.removeAllFromFavorites(FavoriteCourseEntity(course))
            } else {
                favoritesDao.addToFavorites(FavoriteCourseEntity(course))
            }
            loadFavorites()
        }
    }

    fun isFavorite(course: Course): Boolean {
        return favoritesDao.isFavorite(course.id)
    }

    fun clearFavorites() {
        viewModelScope.launch { favoritesDao.removeAllFromFavorites() }
    }
}