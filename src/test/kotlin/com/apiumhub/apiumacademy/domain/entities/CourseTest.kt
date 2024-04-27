package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.shared.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CourseTest {
    @Test
    fun `should create a course`() {
        val courseName = "Some course name"
        val course = Course.create(CourseName(courseName), PositiveInteger(10))
        assertNotNull(course)
        assertEquals(courseName, course.name.value)
    }

    @Test
    fun `should not allow to add students past the limit`() {
        val courseName = "Some course name"
        val course = Course.create(CourseName(courseName), PositiveInteger(1))
        val student = Student.create(StudentName("Some student name"))
        course.registerStudent(student.id)
        assertThrows<StudentsInCourseLimitReachedException> { course.registerStudent(student.id) }
    }
}