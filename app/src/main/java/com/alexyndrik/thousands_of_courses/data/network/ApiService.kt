package com.alexyndrik.thousands_of_courses.data.network

import com.alexyndrik.thousands_of_courses.data.model.Courses
import retrofit2.http.GET

interface ApiService {

    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun loadCourses(): Courses

}