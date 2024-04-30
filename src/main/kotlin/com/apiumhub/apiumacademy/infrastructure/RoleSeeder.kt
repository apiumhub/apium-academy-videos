package com.apiumhub.apiumacademy.infrastructure

import com.apiumhub.apiumacademy.domain.entitites.auth.Role
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import com.apiumhub.apiumacademy.domain.repositories.RoleRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import java.util.*

@Component
class RoleSeeder(private val roleRepository: RoleRepository) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val roleNames = RoleEnum.entries
        roleNames.forEach { roleName ->
            val optionalRole: Optional<Role> = this.roleRepository.findByName(roleName)
            optionalRole.ifPresentOrElse(System.out::println) {
                val roleToCreate = Role(roleName)
                this.roleRepository.save(roleToCreate)
            }
        }
    }

}