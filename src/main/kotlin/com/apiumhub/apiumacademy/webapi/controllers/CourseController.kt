package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.services.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CourseController(val courseService: CourseService) {
    @GetMapping("/courses/{id}")
    fun getCourse(@PathVariable id: String) = courseService.findById(id)

    @GetMapping("/courses")
    fun getCourses() = courseService.findAll()

    @PostMapping("/courses")
    fun createCourse(@RequestBody body: CreateCourseRequestDto) = courseService.insert(body)
}