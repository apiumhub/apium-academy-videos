package com.apiumhub.apiumacademy.application.dto.user.response

import com.apiumhub.apiumacademy.domain.entitites.auth.User

data class UserResponseDto(val id: String, val email: String, val role: String)

fun User.toUserDto() = UserResponseDto(this.userId.id.toString(), this.email.value, this.role.name.toString())