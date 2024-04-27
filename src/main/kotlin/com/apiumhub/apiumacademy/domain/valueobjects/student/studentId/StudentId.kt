package com.apiumhub.apiumacademy.domain.valueobjects.student.studentId

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
class StudentId(override val id: UUID) : EntityId()