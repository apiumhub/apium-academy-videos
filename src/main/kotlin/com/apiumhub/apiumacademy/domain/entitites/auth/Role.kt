package com.apiumhub.apiumacademy.domain.entitites.auth

import jakarta.persistence.*

@Table(name = "roles")
@Entity
class Role(
    @Enumerated(EnumType.STRING) val name: RoleEnum,
    val description: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private val id: Int? = null
}

enum class RoleEnum {
    MEMBER,
    STUDENT,
    TEACHER,
    ADMIN
}