package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.services.CourseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/courses")
class CourseController(val courseService: CourseService) {
    @GetMapping("{id}")
    fun getCourse(@PathVariable id: String) = courseService.findById(id)

    @GetMapping
    fun getCourses() = courseService.findAll()

    @PostMapping
    fun createCourse(@RequestBody body: CreateCourseRequestDto) = courseService.insert(body)
}