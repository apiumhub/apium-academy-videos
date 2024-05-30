package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CourseTest {
    @Test
    fun `should create a course`() {
        val courseName = "Some course name"
        val course = Course.create(CourseName(courseName))
        assertEquals(courseName, course.name.name)
    }
}