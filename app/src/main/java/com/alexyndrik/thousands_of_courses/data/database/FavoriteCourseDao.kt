package com.alexyndrik.thousands_of_courses.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteCourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(course: FavoriteCourseEntity)

    @Delete
    suspend fun removeFromFavorites(course: FavoriteCourseEntity)

    @Query("DELETE FROM favorites")
    suspend fun removeAllFromFavorites()

    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteCourseEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean
}