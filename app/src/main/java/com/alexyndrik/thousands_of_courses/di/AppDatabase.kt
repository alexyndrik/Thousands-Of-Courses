package com.alexyndrik.thousands_of_courses.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseDao
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseEntity

@Database(entities = [FavoriteCourseEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCourseDao(): FavoriteCourseDao
}