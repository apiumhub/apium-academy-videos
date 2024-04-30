package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.domain.entitites.auth.Role
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import com.apiumhub.apiumacademy.domain.repositories.RoleRepository
import com.apiumhub.apiumacademy.domain.repositories.UserRepository
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService(private val userRepository: UserRepository, private val roleRepository: RoleRepository, private val passwordEncoder: PasswordEncoder) {
    fun allUsers(): List<User> = userRepository.findAll()

    fun createAdministrator(input: RegisterUserRequestDto): User {
        val optionalRole: Optional<Role> = roleRepository.findByName(RoleEnum.ADMIN)

        val user = User(UserId(UUID.randomUUID()), input.email, passwordEncoder.encode(input.password), optionalRole.get())

        return userRepository.save(user)
    }
}