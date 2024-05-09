package com.apiumhub.apiumacademy.domain.repositories

import com.apiumhub.apiumacademy.domain.entitites.modules.Module
import com.apiumhub.apiumacademy.domain.valueobjects.modules.module.ModuleId
import org.springframework.data.jpa.repository.JpaRepository

interface ModuleRepository : JpaRepository<Module, ModuleId>