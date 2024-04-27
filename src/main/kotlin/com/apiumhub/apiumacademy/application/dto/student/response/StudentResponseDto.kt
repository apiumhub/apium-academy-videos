package com.apiumhub.apiumacademy.application.dto.student.response

import com.apiumhub.apiumacademy.domain.entitites.Student

data class StudentResponseDto(val id: String, val name: String) {
    companion object {
        fun from(student: Student) = StudentResponseDto(student.id.id.toString(), student.name.value)
    }
}