package com.apiumhub.apiumacademy.application.dto.student.response

import com.apiumhub.apiumacademy.domain.entitites.Student

data class StudentResponseDto(val id: String, val name: String)

fun Student.toStudentDto() = StudentResponseDto(id.id.toString(), name.value)