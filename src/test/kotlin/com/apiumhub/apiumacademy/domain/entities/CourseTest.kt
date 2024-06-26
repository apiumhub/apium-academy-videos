package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.entitites.Teacher
import com.apiumhub.apiumacademy.domain.exceptions.StudentNotInCourseException
import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveInteger
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CourseTest {
    private val courseName = CourseName("Some course name")
    private val course = Course.create(courseName, PositiveInteger(1))
    private val student = Student.create()
    private val teacher = Teacher.create()

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

    @Test
    fun `should add teacher ID when registering teacher in course`() {
        course.registerTeacher(teacher)
        assertTrue(course.isTeacherRegistered(teacher))
    }

    @Test
    fun `should remove teacher ID when unregistering teacher in course`() {
        course.registerTeacher(teacher)
        assertTrue(course.isTeacherRegistered(teacher))
        course.removeTeacher(teacher)
        assertFalse(course.isTeacherRegistered(teacher))
    }
}