package com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherId

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
class TeacherId(override val id: UUID) : EntityId() {
    constructor(id: String) : this(UUID.fromString(id))
    constructor() : this(UUID.randomUUID())
}