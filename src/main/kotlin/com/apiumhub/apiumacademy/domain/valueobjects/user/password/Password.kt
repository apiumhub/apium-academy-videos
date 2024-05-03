package com.apiumhub.apiumacademy.domain.valueobjects.user.password

import com.apiumhub.apiumacademy.domain.exceptions.PasswordTooShortException
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import org.springframework.security.crypto.password.PasswordEncoder

@Embeddable
class Password private constructor(@Embedded val value: String) {

    companion object {
        fun withPlainPassword(plainPassword: String, passwordEncoder: PasswordEncoder): Password {
            if (plainPassword.length < 6)
                throw PasswordTooShortException(plainPassword.length)
            return Password(passwordEncoder.encode(plainPassword))
        }

        fun withEncodedPassword(encodedPassword: String) = Password(encodedPassword)
    }
}