package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.module.CreateModuleRequestDto
import com.apiumhub.apiumacademy.domain.entitites.modules.Module
import com.apiumhub.apiumacademy.domain.repositories.ModuleRepository
import org.springframework.stereotype.Service

@Service
class ModuleService(private val moduleRepository: ModuleRepository) {
    fun createModule(createModuleRequestDto: CreateModuleRequestDto) {
        //TODO
        moduleRepository.save(Module.create())
    }
}