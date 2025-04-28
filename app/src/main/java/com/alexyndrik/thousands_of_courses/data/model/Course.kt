package com.alexyndrik.thousands_of_courses.data.model

import com.alexyndrik.thousands_of_courses.data.database.FavoriteCourseEntity

data class Course(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
) {

    constructor(course: FavoriteCourseEntity) : this(
        id = course.id,
        title = course.title,
        text = course.text,
        price = course.price,
        rate = course.rate,
        startDate = course.startDate,
        hasLike = true,
        publishDate = course.publishDate
    )

}