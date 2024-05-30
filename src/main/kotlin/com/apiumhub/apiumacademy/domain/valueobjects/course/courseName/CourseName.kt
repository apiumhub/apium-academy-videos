package com.apiumhub.apiumacademy.domain.valueobjects.course.courseName

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class CourseName(val name: String)