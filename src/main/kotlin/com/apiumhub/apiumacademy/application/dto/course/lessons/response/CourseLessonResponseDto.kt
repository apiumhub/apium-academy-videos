package com.apiumhub.apiumacademy.application.dto.course.lessons.response

import com.apiumhub.apiumacademy.domain.entitites.Lesson

data class CourseLessonResponseDto(val name: String, val description: String)

fun Lesson.toCourseLessonDto() =  CourseLessonResponseDto(name.value, description.value)