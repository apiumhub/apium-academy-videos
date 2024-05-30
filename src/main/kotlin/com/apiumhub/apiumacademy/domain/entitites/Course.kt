package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import jakarta.persistence.*
import java.util.*

@Table(name = "Courses")
@Entity
class Course private constructor(
    @EmbeddedId val courseId: CourseId,
    @Embedded val name: CourseName
) : AggregateRoot<CourseId>() {
    companion object {
        fun create(name: CourseName) = Course(CourseId(UUID.randomUUID()), name)
    }
}