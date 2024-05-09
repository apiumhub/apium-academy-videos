package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Student
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class StudentTest {

    @Test
    fun `should create a student`() {
        val student = Student.create()
        assertNotNull(student)
    }
}