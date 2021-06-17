package com.example.academies.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagingData
import com.example.academies.data.source.local.entity.CourseEntity
import com.example.academies.data.source.local.entity.CourseWithModule
import com.example.academies.data.source.local.entity.ModuleEntity
import com.example.academies.vo.Resource

interface AcademyDataSource {

    fun getAllCourses(): LiveData<Resource<PagedList<CourseEntity>>>

    fun getBookmarkCourses(): LiveData<PagedList<CourseEntity>>

    fun getCourseWithModule(courseId: String): LiveData<Resource<CourseWithModule>>

    fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>>

    fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>>

    fun setCourseBookmark(course: CourseEntity, state: Boolean)

    fun setReadModule(module: ModuleEntity)
}