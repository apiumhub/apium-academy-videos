package com.apiumhub.apiumacademy.webapi.controllers

import com.apiumhub.apiumacademy.application.dto.course.lessons.request.CreateLessonRequestDto
import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.services.CourseService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/courses")
class CourseController(val courseService: CourseService) {
    @GetMapping("{courseId}")
    fun getCourse(@PathVariable courseId: String) = courseService.findById(courseId)

    @GetMapping
    fun getCourses() =
        courseService.findAll()

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    fun createCourse(@RequestBody body: CreateCourseRequestDto) =
        courseService.insert(body)

    @PostMapping("{courseId}/register/{studentId}")
    fun registerStudent(@PathVariable courseId: String, @PathVariable studentId: String) =
        courseService.registerStudentInCourse(courseId, studentId)

    @PostMapping("{courseId}/unregister/{studentId}")
    fun unregisterStudent(@PathVariable courseId: String, @PathVariable studentId: String) =
        courseService.removeStudentFromCourse(courseId, studentId)

    @PostMapping("{courseId}/lessons")
    fun addLessonToCourse(@PathVariable courseId: String, @RequestBody body: CreateLessonRequestDto) =
        courseService.addLessonToCourse(courseId, body)

    @GetMapping("{courseId}/lessons")
    fun getCourseLessons(@PathVariable courseId: String) =
        courseService.getCourseLessons(courseId)
}