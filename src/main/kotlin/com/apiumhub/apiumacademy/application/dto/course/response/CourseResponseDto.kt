package com.apiumhub.apiumacademy.application.dto.course.response

import com.apiumhub.apiumacademy.domain.entitites.Course

data class CourseResponseDto(val id: String, val name: String)

fun Course.toCourseDto() = CourseResponseDto(id.id.toString(), name.value)