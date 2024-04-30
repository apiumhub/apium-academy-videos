package com.apiumhub.apiumacademy.domain.valueobjects.user.password

import com.apiumhub.apiumacademy.domain.exceptions.PasswordTooShortException
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class Password(@Embedded val value: String) {
    init {
        if (value.length < 6)
            throw PasswordTooShortException(value.length)
    }
}