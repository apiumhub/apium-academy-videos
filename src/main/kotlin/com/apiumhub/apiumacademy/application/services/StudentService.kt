package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.student.request.CreateStudentRequestDto
import com.apiumhub.apiumacademy.application.dto.student.response.StudentResponseDto
import com.apiumhub.apiumacademy.application.dto.student.response.toStudentDto
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
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
            .getOrNull()
            ?.toStudentDto()

    fun findAll() =
        studentRepository
            .findAll()
            .map { it.toStudentDto() }

    fun insert(student: CreateStudentRequestDto) =
        studentRepository
            .save(
                Student.create(
                    StudentName(student.name),
                    Email(student.email)
                )
            ).toStudentDto()
}