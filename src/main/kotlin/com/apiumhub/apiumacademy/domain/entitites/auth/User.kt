package com.apiumhub.apiumacademy.domain.entitites.auth

import com.apiumhub.apiumacademy.domain.entitites.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.EmailConverter
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.Password
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.PasswordConverter
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table(name = "users")
@Entity
class User(
    @EmbeddedId val userId: UserId,
    @Convert(converter = EmailConverter::class) val email: Email,
    @Convert(converter = PasswordConverter::class) val passwordStored: Password,
    @ElementCollection(targetClass = RoleEnum::class, fetch = FetchType.EAGER)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    val roles: MutableSet<RoleEnum>
) : AggregateRoot<UserId>(), UserDetails {

    fun grantRoles(newRoles: Set<RoleEnum>) {
        roles += newRoles
    }

    override fun getId() = userId

    override fun getPassword() = passwordStored.value

    override fun getUsername() = email.value

    override fun getAuthorities() = roles.map { SimpleGrantedAuthority("ROLE_${it.name}") }

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

    companion object {
        fun create(email: Email, password: Password, role: Set<RoleEnum>) =
            User(UserId(), email, password, role.toMutableSet())
    }
}

enum class RoleEnum {
    MEMBER,
    STUDENT,
    TEACHER,
    ADMIN
}