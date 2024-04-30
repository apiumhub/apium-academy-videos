package com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Suppress("JpaAttributeTypeInspection")
@Embeddable
data class PositiveInteger(@Embedded val value: Int) {
    init {
        if (value < 0) {
            throw IllegalArgumentException("Value cannot be negative")
        }
    }

    operator fun inc() = PositiveInteger(value + 1)

    operator fun dec() = PositiveInteger(value - 1)
}