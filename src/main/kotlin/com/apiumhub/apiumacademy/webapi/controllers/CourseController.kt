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
    @PreAuthorize("hasRole('MEMBER')")
    fun getCourse(@PathVariable courseId: String) = courseService.findById(courseId)

    @GetMapping
    @PreAuthorize("hasRole('MEMBER')")
    fun getCourses() =
        courseService.findAll()

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    fun createCourse(@RequestBody body: CreateCourseRequestDto) =
        courseService.insert(body)

    @PostMapping("{courseId}/register/{studentId}")
    @PreAuthorize("hasRole('STUDENT')")
    fun registerStudent(@PathVariable courseId: String, @PathVariable studentId: String) =
        courseService.registerStudentInCourse(courseId, studentId)

    @PostMapping("{courseId}/unregister/{studentId}")
    @PreAuthorize("hasRole('STUDENT')")
    fun unregisterStudent(@PathVariable courseId: String, @PathVariable studentId: String) =
        courseService.removeStudentFromCourse(courseId, studentId)

    @PostMapping("{courseId}/lessons")
    @PreAuthorize("hasRole('TEACHER')")
    fun addLessonToCourse(@PathVariable courseId: String, @RequestBody body: CreateLessonRequestDto) =
        courseService.addLessonToCourse(courseId, body)

    @GetMapping("{courseId}/lessons")
    @PreAuthorize("hasRole('MEMBER')")
    fun getCourseLessons(@PathVariable courseId: String) =
        courseService.getCourseLessons(courseId)
}