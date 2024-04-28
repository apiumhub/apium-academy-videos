package com.apiumhub.apiumacademy.domain.exceptions

class BlockedEmailDomainException(domain: String) : RuntimeException("The domain $domain is blocked.") {
}