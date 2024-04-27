package com.apiumhub.apiumacademy.infrastructure.repositories

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Test
    fun `should insert new course`() {
        val newCourse = Course.create(CourseName("Some name"))
        assertDoesNotThrow {
            val course = courseRepository.save(newCourse)
            assertNotNull(course)
        }
    }
}