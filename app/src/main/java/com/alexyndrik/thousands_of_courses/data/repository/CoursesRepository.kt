package com.alexyndrik.thousands_of_courses.data.repository

import com.alexyndrik.thousands_of_courses.data.model.Course
import com.alexyndrik.thousands_of_courses.data.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CoursesRepository @Inject constructor() {

    private val api: ApiService = Retrofit.Builder()
        .baseUrl("https://drive.usercontent.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun loadCourses(): List<Course> = api.loadCourses().courses

}