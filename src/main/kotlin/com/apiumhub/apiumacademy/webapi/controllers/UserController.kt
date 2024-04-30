package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.user.response.UserResponseDto
import com.apiumhub.apiumacademy.application.dto.user.response.toUserDto
import com.apiumhub.apiumacademy.application.services.UserService
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    fun authenticatedUser(): ResponseEntity<UserResponseDto> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentUser: User = authentication.principal as User
        return ResponseEntity.ok(currentUser.toUserDto())
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN')")
    fun allUsers(): ResponseEntity<List<UserResponseDto>> {
        val users: List<UserResponseDto> = userService.allUsers()
        return ResponseEntity.ok(users)
    }
}