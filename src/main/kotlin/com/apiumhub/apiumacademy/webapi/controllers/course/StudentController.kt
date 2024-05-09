package com.apiumhub.apiumacademy.webapi.controllers.course

import com.apiumhub.apiumacademy.application.services.StudentService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/students")
class StudentController(private val studentService: StudentService) {
    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    fun getCourse(@PathVariable id: String) = studentService.findById(id)

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    fun getAllStudents() = studentService.findAll()
}