package com.alexyndrik.thousands_of_courses.data.repository

import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseDao
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseEntity
import javax.inject.Inject

class FavoriteCoursesRepository @Inject constructor(
    private val favoriteCourseDao: FavoriteCourseDao
) {

    suspend fun addToFavorites(course: FavoriteCourseEntity) {
        favoriteCourseDao.addToFavorites(course)
    }

    suspend fun removeFromFavorites(course: FavoriteCourseEntity) {
        favoriteCourseDao.removeFromFavorites(course)
    }

    suspend fun removeAllFromFavorites() {
        favoriteCourseDao.removeAllFromFavorites()
    }

    suspend fun getAllFavorites() = favoriteCourseDao.getAllFavorites()

    suspend fun isFavorite(id: Int) = favoriteCourseDao.isFavorite(id)

}