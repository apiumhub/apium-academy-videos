package com.apiumhub.apiumacademy.application.dto.user.response

import com.apiumhub.apiumacademy.domain.entitites.auth.User

data class UserResponseDto(val id: String, val email: String, val roles: Set<String>)

fun User.toUserDto() = UserResponseDto(userId.id.toString(), email.value, roles.map { it.name.toString() }.toSet())