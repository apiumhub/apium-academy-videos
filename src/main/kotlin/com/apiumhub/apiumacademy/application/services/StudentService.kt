package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.student.request.CreateStudentRequestDto
import com.apiumhub.apiumacademy.application.dto.student.response.StudentResponseDto
import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.entitites.StudentId
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun findById(id: String): StudentResponseDto? = studentRepository
        .findById(StudentId(UUID.fromString(id)))
        .map { StudentResponseDto(it.id.id.toString(), it.name) }
        .getOrNull()

    fun findAll() = studentRepository
        .findAll()
        .map { StudentResponseDto(it.id.id.toString(), it.name) }

    fun insert(student: CreateStudentRequestDto) = studentRepository.save(Student.create(student.name))
}