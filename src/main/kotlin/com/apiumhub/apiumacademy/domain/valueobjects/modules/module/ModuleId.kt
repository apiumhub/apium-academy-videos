package com.apiumhub.apiumacademy.domain.valueobjects.modules.module

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
class ModuleId(override val id: UUID) : EntityId() {
    constructor(id: String) : this(UUID.fromString(id))
    constructor() : this(UUID.randomUUID())
}