package com.example.academies.ui.reader

import androidx.lifecycle.ViewModel
import com.example.academies.data.ContentEntity
import com.example.academies.data.ModuleEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.utils.DataDummy

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseID: String) {
        this.courseId = courseID
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

    fun getSelectedModule(): ModuleEntity = academyRepository.getContent(courseId, moduleId)
}