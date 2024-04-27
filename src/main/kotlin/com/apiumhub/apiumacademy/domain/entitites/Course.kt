package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseNameConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Table(name = "Courses")
@Entity
class Course(
    @EmbeddedId val courseId: CourseId,
    @Convert(converter = CourseNameConverter::class) val name: CourseName
) : AggregateRoot<CourseId>() {

    override fun getId() = courseId

    companion object {
        fun create(name: CourseName) = Course(CourseId(UUID.randomUUID()), name)
    }
}