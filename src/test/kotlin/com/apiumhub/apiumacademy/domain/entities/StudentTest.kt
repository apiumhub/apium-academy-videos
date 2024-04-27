package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class StudentTest {

    @Test
    fun `should create a student`() {
        val studentName = "Some student name"
        val student = Student.create(StudentName(studentName))
        assertNotNull(student)
        assertEquals(studentName, student.name.value)
    }
}