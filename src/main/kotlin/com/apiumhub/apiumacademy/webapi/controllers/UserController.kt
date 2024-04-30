package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.services.UserService
import com.apiumhub.apiumacademy.domain.entitites.User
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/me")
    fun authenticatedUser(): ResponseEntity<User> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentUser: User = authentication.principal as User
        return ResponseEntity.ok(currentUser)
    }

    @GetMapping("/")
    fun allUsers(): ResponseEntity<List<User>> {
        val users: List<User> = userService.allUsers()
        return ResponseEntity.ok(users)
    }
}