package com.apiumhub.apiumacademy.domain.entitites.auth

import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.EmailConverter
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.Password
import com.apiumhub.apiumacademy.domain.valueobjects.user.password.PasswordConverter
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table(name = "users")
@Entity
class User(
    @EmbeddedId val userId: UserId,
    @Convert(converter = EmailConverter::class) val email: Email,
    @Convert(converter = PasswordConverter::class) val passwordStored: Password,
    @OneToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    val role: Role
) : UserDetails {

    override fun getPassword(): String {
        return passwordStored.value
    }

    override fun getUsername(): String {
        return email.value
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

    companion object {
        fun create(email: Email, password: Password, role: Role) = User(UserId(), email, password, role)
    }
}

