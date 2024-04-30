package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.application.services.UserService
import com.apiumhub.apiumacademy.domain.entitites.auth.User
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/admins")
@RestController
class AdminController(private val userService: UserService) {
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    fun createAdministrator(@RequestBody registerUserDto: RegisterUserRequestDto): ResponseEntity<User> {
        val createdAdmin: User = userService.createAdministrator(registerUserDto)

        return ResponseEntity.ok(createdAdmin)
    }
}