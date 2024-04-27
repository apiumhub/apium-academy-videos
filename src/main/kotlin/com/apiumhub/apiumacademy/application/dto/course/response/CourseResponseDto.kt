package com.apiumhub.apiumacademy.application.dto.course.response

import com.apiumhub.apiumacademy.domain.entitites.Course

data class CourseResponseDto(val id: String, val name: String){
    companion object{
        fun from(course: Course)= CourseResponseDto(course.id.id.toString(), course.name.value)
    }
}