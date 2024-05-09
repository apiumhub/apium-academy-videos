package com.apiumhub.apiumacademy.domain.valueObjects

import com.apiumhub.apiumacademy.domain.exceptions.PasswordTooShortException
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.Password
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

class PasswordTest {

    private val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Test
    fun `should throw exception is password length is below 6 chars`() {
        assertThrows<PasswordTooShortException> { Password.withPlainPassword("12345", passwordEncoder) }
    }

    @Test
    fun `should create encoded password when all requirements are met`() {
        val encodedPassword = Password.withPlainPassword("123456", passwordEncoder)
        assertNotNull(encodedPassword)
    }
}