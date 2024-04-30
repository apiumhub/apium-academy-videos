package com.apiumhub.apiumacademy.domain.entitites.auth

import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Table(name = "users")
@Entity
class User(
    @EmbeddedId val userId: UserId,
    val email: String,
    val passwordStored: String,
    @OneToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    val role: Role
) : UserDetails {

    override fun getPassword(): String {
        return passwordStored
    }

    override fun getUsername(): String {
        return email
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authority = SimpleGrantedAuthority("ROLE_" + role.name.toString())

        return listOf(authority)
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

