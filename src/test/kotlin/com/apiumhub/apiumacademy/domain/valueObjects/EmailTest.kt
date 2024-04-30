package com.apiumhub.apiumacademy.domain.valueObjects

import com.apiumhub.apiumacademy.domain.exceptions.BlockedEmailDomainException
import com.apiumhub.apiumacademy.domain.exceptions.InvalidEmailException
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class EmailTest {

    @Test
    fun `should not throw with a valid email format`() {
        assertDoesNotThrow { Email("test@domain.com") }
    }

    @Test
    fun `should throw invalid email exception when email format is incorrect`() {
        assertThrows<InvalidEmailException> { Email("test") }
    }

    @Test
    fun `should throw BlockedEmailDomainException when creating an email with a blocked domain`() {
        assertThrows<BlockedEmailDomainException> { Email("test@example.com") }
    }
}