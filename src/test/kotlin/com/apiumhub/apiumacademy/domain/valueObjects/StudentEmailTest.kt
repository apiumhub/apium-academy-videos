package com.apiumhub.apiumacademy.domain.valueObjects

import com.apiumhub.apiumacademy.domain.exceptions.BlockedEmailDomainException
import com.apiumhub.apiumacademy.domain.exceptions.InvalidEmailException
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentEmail.StudentEmail
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class StudentEmailTest {

    @Test
    fun `should not throw with a valid email format`() {
        assertDoesNotThrow { StudentEmail("test@domain.com") }
    }

    @Test
    fun `should throw invalid email exception when email format is incorrect`() {
        assertThrows<InvalidEmailException> { StudentEmail("test") }
    }

    @Test
    fun `should throw BlockedEmailDomainException when creating an email with a blocked domain`() {
        assertThrows<BlockedEmailDomainException> { StudentEmail("test@example.com") }
    }
}