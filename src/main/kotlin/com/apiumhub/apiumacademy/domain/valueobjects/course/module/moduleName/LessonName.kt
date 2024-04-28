package com.apiumhub.apiumacademy.domain.valueobjects.course.module.moduleName

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class LessonName(@Embedded val value: String)