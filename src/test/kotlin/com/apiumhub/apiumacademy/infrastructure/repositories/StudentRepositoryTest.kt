package com.apiumhub.apiumacademy.infrastructure.repositories

import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.exceptions.StudentNotFoundException
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Test //Dummy test to check repository & db integrity
    fun `should insert new student`() {
        val newStudent = Student.create(StudentName("Some name"), Email("email@domain.com"))
        assertDoesNotThrow {
            val student = studentRepository.save(newStudent)
            assertNotNull(student)
        }
    }

    @Test
    @Disabled
    fun `should throw exception when student not found by id`() {
        //TODO
        assertThrows<StudentNotFoundException> { studentRepository.findStudentById(StudentId(UUID.randomUUID())) }
    }
}