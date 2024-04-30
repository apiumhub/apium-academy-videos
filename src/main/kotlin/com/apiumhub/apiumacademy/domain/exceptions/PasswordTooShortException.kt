package com.apiumhub.apiumacademy.domain.exceptions

class PasswordTooShortException(currentPasswordLength: Int) : RuntimeException("Password must be at least 6 characters but is $currentPasswordLength")