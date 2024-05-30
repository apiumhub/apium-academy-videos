package com.apiumhub.apiumacademy.application.dto.student.response

import com.apiumhub.apiumacademy.domain.entitites.Student

data class StudentResponseDto(val id: String, val name: String) {
    companion object {
        fun from(student: Student) = StudentResponseDto(student.studentId.id.toString(), student.name.name)
    }
}