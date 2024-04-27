package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.student.request.CreateStudentRequestDto
import com.apiumhub.apiumacademy.application.services.StudentService
import org.springframework.web.bind.annotation.*

@RestController
class StudentController(private val studentService: StudentService) {
    @GetMapping("/students/{id}")
    fun getCourse(@PathVariable id: String) = studentService.findById(id)

    @GetMapping("/students")
    fun getCourses() = studentService.findAll()

    @PostMapping("/students")
    fun createCourse(@RequestBody body: CreateStudentRequestDto) = studentService.insert(body)
}