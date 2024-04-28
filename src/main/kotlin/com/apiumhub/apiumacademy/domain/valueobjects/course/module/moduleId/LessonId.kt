package com.apiumhub.apiumacademy.domain.valueobjects.course.module.moduleId

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
class LessonId(override val id: UUID) : EntityId()