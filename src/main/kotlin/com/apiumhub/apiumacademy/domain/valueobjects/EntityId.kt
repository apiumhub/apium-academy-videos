package com.apiumhub.apiumacademy.domain.valueobjects

import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
abstract class EntityId {
    abstract val id: UUID
}