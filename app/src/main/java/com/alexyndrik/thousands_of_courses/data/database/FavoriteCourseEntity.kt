package com.alexyndrik.thousands_of_courses.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexyndrik.thousands_of_courses.data.model.Course

@Entity(tableName = "favorites")
data class FavoriteCourseEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val publishDate: String
) {

    constructor(course: Course): this(
        id = course.id,
        title = course.title,
        text = course.text,
        price = course.price,
        rate = course.rate,
        startDate = course.startDate,
        publishDate = course.publishDate
    )

}