package com.apiumhub.apiumacademy.domain.valueobjects.user.password

import com.apiumhub.apiumacademy.domain.exceptions.PasswordTooShortException
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class Password(@Embedded val value: String) {
    //TODO This is useless as long as the value passed is the encoded password.
    init {
        if (value.length < 6)
            throw PasswordTooShortException(value.length)
    }
}