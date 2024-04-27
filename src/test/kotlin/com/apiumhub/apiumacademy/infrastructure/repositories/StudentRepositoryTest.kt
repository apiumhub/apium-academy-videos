package com.apiumhub.apiumacademy.infrastructure.repositories

import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Test
    fun `should insert new student`() {
        val newStudent = Student.create(StudentName("Some name"))
        assertDoesNotThrow {
            val student = studentRepository.save(newStudent)
            assertNotNull(student)
        }
    }
}