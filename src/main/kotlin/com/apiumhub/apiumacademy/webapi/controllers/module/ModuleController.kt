package com.apiumhub.apiumacademy.webapi.controllers.module

import com.apiumhub.apiumacademy.application.dto.module.CreateModuleRequestDto
import com.apiumhub.apiumacademy.application.services.ModuleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/modules")
class ModuleController(private val moduleService: ModuleService) {

    @PostMapping
    fun createModule(@RequestBody createModuleBody: CreateModuleRequestDto) {
        moduleService.createModule(createModuleBody)
    }
}