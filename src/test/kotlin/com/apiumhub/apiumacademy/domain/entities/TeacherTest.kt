package com.apiumhub.apiumacademy.domain.entities

import com.apiumhub.apiumacademy.domain.entitites.Teacher
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class TeacherTest {
    @Test
    fun `should create a teacher`() {
        val teacher = Teacher.create()
        assertNotNull(teacher)
    }
}