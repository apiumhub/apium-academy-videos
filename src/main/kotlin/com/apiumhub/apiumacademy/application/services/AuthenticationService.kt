package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.user.request.LoginUserRequestDto
import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import com.apiumhub.apiumacademy.domain.repositories.RoleRepository
import com.apiumhub.apiumacademy.domain.repositories.UserRepository
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.Password
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository
) {
    fun signup(input: RegisterUserRequestDto): User {
        val memberRole = roleRepository.findByName(RoleEnum.MEMBER)
        return userRepository.save(
            User(
                UserId(),
                Email(input.email),
                Password(passwordEncoder.encode(input.password)),
                memberRole.get()
            )
        )
    }

    fun authenticate(input: LoginUserRequestDto): User {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(input.email, input.password))
        return userRepository.findByEmail(Email(input.email)).orElseThrow()
    }
}