package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.services.CourseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/courses")
class CourseController(val courseService: CourseService) {
    @GetMapping("{courseId}")
    fun getCourse(@PathVariable courseId: String) = courseService.findById(courseId)

    @GetMapping
    fun getCourses() = courseService.findAll()

    @PostMapping
    fun createCourse(@RequestBody body: CreateCourseRequestDto) = courseService.insert(body)

    @PostMapping("{courseId}/register/{studentId}")
    fun registerStudent(@PathVariable courseId: String, @PathVariable studentId: String) = courseService.registerStudentInCourse(courseId, studentId)
}