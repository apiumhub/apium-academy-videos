package com.apiumhub.apiumacademy.application.dto.module.lessons.response

import com.apiumhub.apiumacademy.domain.entitites.modules.Lesson

data class CourseLessonResponseDto(val name: String, val description: String)

fun Lesson.toCourseLessonDto() =  CourseLessonResponseDto(name.value, description.value)