package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.CourseId
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun findById(id: String) = courseRepository.findById(CourseId(UUID.fromString(id)))
    fun insert(course: CreateCourseRequestDto) = courseRepository.save(Course.create(course.name))
}