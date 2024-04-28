package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.student.request.CreateStudentRequestDto
import com.apiumhub.apiumacademy.application.dto.student.response.StudentResponseDto
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentEmail.StudentEmail
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun findById(id: String): StudentResponseDto? =
        studentRepository
            .findById(StudentId(UUID.fromString(id)))
            .map { StudentResponseDto.from(it) }
            .getOrNull()

    fun findAll() =
        studentRepository
            .findAll()
            .map { StudentResponseDto.from(it) }

    fun insert(student: CreateStudentRequestDto) =
        StudentResponseDto.from(
            studentRepository
                .save(
                    Student.create(
                        StudentName(student.name),
                        StudentEmail(student.email)
                    )
                )
        )
}