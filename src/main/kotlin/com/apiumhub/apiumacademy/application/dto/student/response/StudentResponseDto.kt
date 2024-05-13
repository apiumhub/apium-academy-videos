package com.apiumhub.apiumacademy.application.dto.student.response

import com.apiumhub.apiumacademy.domain.entitites.Student

data class StudentResponseDto(val id: String)

fun Student.toStudentDto() = StudentResponseDto(studentId.toString())