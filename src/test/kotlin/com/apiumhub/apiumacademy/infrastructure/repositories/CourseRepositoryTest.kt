package com.apiumhub.apiumacademy.infrastructure.repositories

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.exceptions.CourseNotFoundException
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveInteger
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Test //Dummy test to check repository & db integrity
    fun `should insert new course`() {
        val newCourse = Course.create(CourseName("Some name"), PositiveInteger(1))
        assertDoesNotThrow {
            val course = courseRepository.save(newCourse)
            assertNotNull(course)
        }
    }

    @Test
    @Disabled
    fun `should throw exception when course not found by id`() {
        assertThrows<CourseNotFoundException> { courseRepository.findCourseById(CourseId(UUID.randomUUID())) }
    }
}