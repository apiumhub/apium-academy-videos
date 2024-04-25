package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.CourseId
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun findById(id: CourseId) = courseRepository.findById(id)
    fun insert(course: Course) = courseRepository.save(course)
}