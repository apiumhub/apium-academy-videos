package com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonName

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class LessonName(@Embedded val value: String)