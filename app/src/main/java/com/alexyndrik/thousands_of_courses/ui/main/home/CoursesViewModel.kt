package com.alexyndrik.thousands_of_courses.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexyndrik.thousands_of_courses.data.model.Course
import com.alexyndrik.thousands_of_courses.data.repository.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val repository: CoursesRepository
): ViewModel() {

    private val _courses = MutableLiveData<List<Course>>()
    val courses: LiveData<List<Course>> get() = _courses

    fun loadCourses() {
        viewModelScope.launch {
            _courses.value = repository.loadCourses()
        }
    }

    fun sortByPublishDate() {
        _courses.postValue(_courses.value?.sortedBy { it.publishDate })
    }

}