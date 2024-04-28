package com.apiumhub.apiumacademy.application.dto.course.lessons.response

import com.apiumhub.apiumacademy.domain.entitites.Lesson

data class CourseLessonResponseDto(val name: String, val description: String) {
    companion object {
        fun from(lesson: Lesson) = CourseLessonResponseDto(lesson.name.value, lesson.description.value)
    }
}