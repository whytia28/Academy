package com.example.academies.data.source

import androidx.lifecycle.LiveData
import com.example.academies.data.CourseEntity
import com.example.academies.data.ModuleEntity

interface AcademyDataSource {

    fun getAllCourses(): LiveData<List<CourseEntity>>

    fun getBookmarkCourses(): LiveData<List<CourseEntity>>

    fun getCourseWithModule(courseId: String): LiveData<CourseEntity>

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>

    fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>
}