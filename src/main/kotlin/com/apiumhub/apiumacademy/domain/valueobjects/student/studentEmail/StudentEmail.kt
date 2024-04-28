package com.apiumhub.apiumacademy.domain.valueobjects.student.studentEmail

import com.apiumhub.apiumacademy.domain.exceptions.BlockedEmailDomainException
import com.apiumhub.apiumacademy.domain.exceptions.InvalidEmailException
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import java.util.regex.Matcher
import java.util.regex.Pattern

@Embeddable
class StudentEmail(@Embedded val value: String) {

    @Transient
    val blockedDomains = listOf("test.com", "example.com")

    init {
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val matcher: Matcher = pattern.matcher(value)
        val matchFound: Boolean = matcher.matches()
        if (!matchFound) throw InvalidEmailException(value)
        val domain = value.split("@").last()
        if (domain in blockedDomains) throw BlockedEmailDomainException(domain)
    }

}