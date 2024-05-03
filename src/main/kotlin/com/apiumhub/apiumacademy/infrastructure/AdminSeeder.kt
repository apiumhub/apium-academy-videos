package com.apiumhub.apiumacademy.infrastructure

import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.repositories.UserRepository
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.Password
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AdminSeeder(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(contextRefreshedEvent: ContextRefreshedEvent) {
        val userDto = RegisterUserRequestDto("admin@academy.com", "123456", "First admin")

        val optionalRole = RoleEnum.ADMIN
        val optionalUser = userRepository.findByEmail(Email(userDto.email))

        if (optionalUser.isPresent) return

        val user = User.create(
            Email(userDto.email),
            Password.withPlainPassword(userDto.password, passwordEncoder),
            setOf(optionalRole)
        )

        userRepository.save<User>(user)
    }
}