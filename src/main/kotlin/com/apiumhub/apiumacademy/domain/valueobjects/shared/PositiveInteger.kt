package com.apiumhub.apiumacademy.domain.valueobjects.shared

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class PositiveInteger(@Embedded val value: Int) {
    init {
        if (value < 0) {
            throw IllegalArgumentException("Value cannot be negative")
        }
    }

    operator fun inc(): PositiveInteger {
        return PositiveInteger(value + 1)
    }
}