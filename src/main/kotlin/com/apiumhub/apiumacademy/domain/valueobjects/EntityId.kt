package com.apiumhub.apiumacademy.domain.valueobjects

import java.io.Serializable
import java.util.*

abstract class EntityId : Serializable {
    abstract val id: UUID

    override fun toString(): String {
        return id.toString()
    }
}