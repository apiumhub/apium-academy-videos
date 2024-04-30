package com.apiumhub.apiumacademy.domain.repositories

import com.apiumhub.apiumacademy.domain.entitites.auth.Role
import com.apiumhub.apiumacademy.domain.entitites.auth.RoleEnum
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository : CrudRepository<Role, Int> {
    fun findByName(name: RoleEnum): Optional<Role>
}