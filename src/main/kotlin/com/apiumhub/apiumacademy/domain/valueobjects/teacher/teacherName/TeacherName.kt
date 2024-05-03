package com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherName

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class TeacherName(@Embedded val value: String)