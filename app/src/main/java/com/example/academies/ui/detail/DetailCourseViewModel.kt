package com.example.academies.ui.detail

import androidx.lifecycle.ViewModel
import com.example.academies.data.CourseEntity
import com.example.academies.data.ModuleEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModule(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}