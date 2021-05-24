package com.example.academies.data.source

import com.example.academies.data.CourseEntity
import com.example.academies.data.ModuleEntity

interface AcademyDataSource {

    fun getAllCourses(): List<CourseEntity>

    fun getBookmarkCourses(): List<CourseEntity>

    fun getCourseWithModule(courseId: String): CourseEntity

    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>

    fun getContent(courseId: String, moduleId: String): ModuleEntity
}