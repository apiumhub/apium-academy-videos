package com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonDescription

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded


@Embeddable
data class LessonDescription(@Embedded val value: String)