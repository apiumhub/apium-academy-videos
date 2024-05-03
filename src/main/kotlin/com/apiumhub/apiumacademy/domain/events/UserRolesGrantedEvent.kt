package com.apiumhub.apiumacademy.domain.events

import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import java.time.Instant
import java.util.*

data class UserRolesGrantedEvent(
    override val aggregateId: UserId,
    val grantedRoles: Set<RoleEnum>
) : UserEvent {
    override val id: UUID = UUID.randomUUID()
    override val timestamp: Instant = Instant.now()
}