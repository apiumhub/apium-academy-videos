package com.apiumhub.apiumacademy.infrastructure

import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.domain.entitites.auth.Role
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import com.apiumhub.apiumacademy.domain.repositories.RoleRepository
import com.apiumhub.apiumacademy.domain.repositories.UserRepository
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*


@Component
class AdminSeeder(
    private val roleRepository: RoleRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(contextRefreshedEvent: ContextRefreshedEvent) {
        val userDto = RegisterUserRequestDto("super.admin@email.com", "123456", "First admin")

        val optionalRole: Optional<Role> = roleRepository.findByName(RoleEnum.ADMIN)
        val optionalUser: Optional<User> = userRepository.findByEmail(userDto.email)

        if (optionalUser.isPresent || optionalRole.isEmpty)
            return

        val user = User(UserId(UUID.randomUUID()), userDto.email, passwordEncoder.encode(userDto.password), optionalRole.get())

        userRepository.save<User>(user)
    }
}