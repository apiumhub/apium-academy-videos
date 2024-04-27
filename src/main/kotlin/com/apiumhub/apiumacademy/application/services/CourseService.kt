package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.dto.course.response.CourseResponseDto
import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun findById(id: String): CourseResponseDto? = courseRepository.findById(CourseId(UUID.fromString(id))).map { CourseResponseDto.from(it) }.getOrNull()

    fun findAll() = courseRepository.findAll().map { CourseResponseDto.from(it) }

    fun insert(course: CreateCourseRequestDto) = CourseResponseDto.from(
        courseRepository.save(
            Course.create(
                CourseName(course.name)
            )
        )
    )
}