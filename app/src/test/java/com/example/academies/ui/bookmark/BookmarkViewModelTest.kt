package com.example.academies.ui.bookmark

import com.example.academies.data.CourseEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setup() {
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmarks() {
        `when`(academyRepository.getBookmarkCourses()).thenReturn(DataDummy.generateDummyCourses() as ArrayList<CourseEntity>)
        val courseEntities = viewModel.getBookmarks()
        verify(academyRepository).getBookmarkCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}