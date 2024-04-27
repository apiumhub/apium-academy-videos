package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.student.request.CreateStudentRequestDto
import com.apiumhub.apiumacademy.application.services.StudentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/students")
class StudentController(private val studentService: StudentService) {
    @GetMapping("{id}")
    fun getCourse(@PathVariable id: String) = studentService.findById(id)

    @GetMapping
    fun getCourses() = studentService.findAll()

    @PostMapping
    fun createCourse(@RequestBody body: CreateStudentRequestDto) = studentService.insert(body)
}