package com.apiumhub.apiumacademy.domain.events

import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import java.time.Instant
import java.util.*

abstract class DomainEvent

sealed interface UserEvent {
    val id: UUID
    val timestamp: Instant
    val aggregateId: UserId
}