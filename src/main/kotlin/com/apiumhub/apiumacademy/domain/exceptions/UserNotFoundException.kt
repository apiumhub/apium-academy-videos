package com.apiumhub.apiumacademy.domain.exceptions

class UserNotFoundException(id: String) : RuntimeException("User with ID '$id' not found")