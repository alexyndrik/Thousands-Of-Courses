package com.alexyndrik.thousands_of_courses.di

import android.content.Context
import androidx.room.Room
import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideFavoriteCourseDao(appDatabase: AppDatabase): FavoriteCourseDao {
        return appDatabase.favoriteCourseDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            AppDatabase::class.java,
            "courses-db"
        )
            .allowMainThreadQueries()
            .build()
    }
}