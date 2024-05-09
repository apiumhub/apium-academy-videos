package com.apiumhub.apiumacademy.application.services.auth

import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.application.dto.user.response.UserResponseDto
import com.apiumhub.apiumacademy.application.dto.user.response.toUserDto
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import com.apiumhub.apiumacademy.domain.exceptions.UserNotFoundException
import com.apiumhub.apiumacademy.domain.repositories.UserRepository
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.Password
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun allUsers(): List<UserResponseDto> = userRepository.findAll().map { it.toUserDto() }

    fun createAdministrator(input: RegisterUserRequestDto): UserResponseDto {
        val optionalRole = RoleEnum.ADMIN

        val user = User.create(
            Email(input.email),
            Password.withPlainPassword(input.password, passwordEncoder),
            setOf(optionalRole)
        )
        return userRepository.save(user).toUserDto()
    }

    fun grantRoles(userId: String, roles: List<String>) {
        val user = userRepository.findById(UserId(userId)).orElseThrow { UserNotFoundException(userId) }
        val newRolesEnums = roles.map { RoleEnum.valueOf(it.uppercase()) }.toSet()
        user.grantRoles(newRolesEnums)
        userRepository.save(user)
    }
}