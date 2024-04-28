package com.apiumhub.apiumacademy.domain.repositories

import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.exceptions.CourseNotFoundException
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : CrudRepository<Course, CourseId> {
    fun findCourseById(courseId: CourseId): Course =
        findById(courseId).orElseThrow { CourseNotFoundException(courseId) }
}