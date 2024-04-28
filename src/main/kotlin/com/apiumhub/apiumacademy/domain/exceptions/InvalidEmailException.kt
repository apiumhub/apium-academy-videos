package com.apiumhub.apiumacademy.domain.exceptions

class InvalidEmailException(email: String) : RuntimeException("Invalid email: $email") {
}