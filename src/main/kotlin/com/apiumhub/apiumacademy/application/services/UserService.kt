package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.domain.entitites.User
import com.apiumhub.apiumacademy.domain.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun allUsers(): List<User> = userRepository.findAll()
}