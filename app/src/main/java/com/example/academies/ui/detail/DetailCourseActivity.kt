package com.example.academies.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.academies.databinding.ActivityDetailCourseBinding
import com.example.academies.databinding.ContentDetailCourseBinding

class DetailCourseActivity : AppCompatActivity() {

    private lateinit var detailCourseBinding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailCourseBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

}