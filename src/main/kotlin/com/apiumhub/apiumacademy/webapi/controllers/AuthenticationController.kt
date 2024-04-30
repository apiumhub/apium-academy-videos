package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.user.request.LoginUserRequestDto
import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.application.dto.user.response.LoginUserResponseDto
import com.apiumhub.apiumacademy.application.services.AuthenticationService
import com.apiumhub.apiumacademy.application.services.JwtService
import com.apiumhub.apiumacademy.domain.entitites.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthenticationController(private val jwtService: JwtService, private val authenticationService: AuthenticationService) {
    @PostMapping("/signup")
    fun register(@RequestBody registerUserDto: RegisterUserRequestDto): ResponseEntity<User> {
        val registeredUser: User = authenticationService.signup(registerUserDto)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun authenticate(@RequestBody loginUserDto: LoginUserRequestDto): ResponseEntity<LoginUserResponseDto> {
        val authenticatedUser: User = authenticationService.authenticate(loginUserDto)
        val jwtToken = jwtService.generateToken(authenticatedUser)
        val loginResponse = LoginUserResponseDto(jwtToken, jwtService.expirationTime)
        return ResponseEntity.ok(loginResponse)
    }
}