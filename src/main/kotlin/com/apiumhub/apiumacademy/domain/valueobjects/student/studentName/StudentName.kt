package com.apiumhub.apiumacademy.domain.valueobjects.student.studentName

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class StudentName(@Embedded val value: String)