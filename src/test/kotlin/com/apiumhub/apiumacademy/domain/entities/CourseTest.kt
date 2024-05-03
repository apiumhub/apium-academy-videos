package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.exceptions.StudentNotInCourseException
import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherName.TeacherName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CourseTest {
    private val courseName = CourseName("Some course name")
    private val course = Course.create(courseName, PositiveInteger(1))
    private val student = Student.create(TeacherName("Some student name"), Email("email@domain.com"))

    @Test
    fun `should create a course`() {
        assertNotNull(course)
    }

    @Test
    fun `should add student to course`() {
        val courseName = "Some course name"
        val course = Course.create(CourseName(courseName), PositiveInteger(1))
        course.registerStudent(student)
        assertTrue(course.isStudentRegistered(student))
    }

    @Test
    fun `should not allow to add students past the limit`() {
        course.registerStudent(student)
        assertThrows<StudentsInCourseLimitReachedException> { course.registerStudent(student) }
    }

    @Test
    fun `should remove student from course`() {
        course.registerStudent(student)
        course.removeStudent(student)
        assertFalse(course.isStudentRegistered(student))
    }

    @Test
    fun `should throw exception when removing a student not registered in the course`() {
        assertThrows<StudentNotInCourseException> { course.removeStudent(student) }
    }
}