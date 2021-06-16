package com.example.academies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.academies.data.AcademyRepository
import com.example.academies.data.source.local.entity.CourseWithModule
import com.example.academies.vo.Resource

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    val courseId = MutableLiveData<String>()

    fun setSelectedCourse(courseId: String) {
        this.courseId.value = courseId
    }


    var courseModule: LiveData<Resource<CourseWithModule>> = Transformations.switchMap(courseId) { mCourseId ->
        academyRepository.getCourseWithModule(mCourseId)
    }

    fun setBookmark() {
        val moduleResource = courseModule.value
        if (moduleResource != null) {
            val courseWithModule = moduleResource.data

            if (courseWithModule != null) {
                val courseEntity = courseWithModule.mCourse
                val newState = !courseEntity.bookmarked
                academyRepository.setCourseBookmark(courseEntity,newState)
            }
        }
    }

}