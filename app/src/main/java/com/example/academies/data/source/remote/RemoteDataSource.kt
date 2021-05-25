package com.example.academies.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.academies.data.source.remote.response.ContentResponse
import com.example.academies.data.source.remote.response.CourseResponse
import com.example.academies.data.source.remote.response.ModuleResponse
import com.example.academies.utils.EspressoIdlingResource
import com.example.academies.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper).apply { instance = this }
        }
    }

    fun getAllCourses(callBack: LoadCoursesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callBack.onAllCoursesReceived(jsonHelper.loadCourses())
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getModules(courseId: String, callBack: LoadModulesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callBack.onAllModulesReceived(jsonHelper.loadModule(courseId))
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getContent(moduleId: String, callBack: LoadContentCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callBack.onContentReceived(jsonHelper.loadContent(moduleId))
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadCoursesCallback {
        fun onAllCoursesReceived(courseResponse: List<CourseResponse>)
    }

    interface LoadModulesCallback {
        fun onAllModulesReceived(moduleResponses: List<ModuleResponse>)
    }

    interface LoadContentCallback {
        fun onContentReceived(contentResponse: ContentResponse)
    }
}