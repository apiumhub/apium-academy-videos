package com.apiumhub.apiumacademy.domain.valueobjects.user.userId

import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
class UserId(override val id: UUID) : EntityId() {
    constructor(id: String) : this(UUID.fromString(id))
}