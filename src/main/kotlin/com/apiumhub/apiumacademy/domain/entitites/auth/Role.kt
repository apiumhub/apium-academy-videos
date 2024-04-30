package com.apiumhub.apiumacademy.domain.entitites.auth

import jakarta.persistence.*

@Table(name = "roles")
@Entity
class Role(
    @Enumerated(EnumType.STRING) val name: RoleEnum
) {
    @Id
    @Column(nullable = false)
    private val id: Int = RoleEnum.valueOf(name.toString()).ordinal
}

enum class RoleEnum {
    MEMBER,
    STUDENT,
    TEACHER,
    ADMIN
}