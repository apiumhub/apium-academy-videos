package com.apiumhub.apiumacademy.webapi.controllers.auth

import com.apiumhub.apiumacademy.application.dto.user.request.RegisterUserRequestDto
import com.apiumhub.apiumacademy.application.services.auth.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RequestMapping("/admin")
@RestController
class AdminController(private val userService: UserService) {
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    fun createAdministrator(@RequestBody registerUserDto: RegisterUserRequestDto) =
        ResponseEntity.ok(userService.createAdministrator(registerUserDto))

    @PostMapping("/{userId}/roles")
    @PreAuthorize("hasRole('ADMIN')")
    fun grantRole(@PathVariable userId: String, @RequestBody roles: List<String>) {
        userService.grantRoles(userId, roles)
    }
}