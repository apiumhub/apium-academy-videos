package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseNameConverter
import com.apiumhub.apiumacademy.domain.valueobjects.shared.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.shared.PositiveIntegerConverter
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import jakarta.persistence.*
import java.util.*

@Table(name = "Courses")
@Entity
class Course private constructor(
    @EmbeddedId val courseId: CourseId,
    @Convert(converter = CourseNameConverter::class) var name: CourseName,
    @Convert(converter = PositiveIntegerConverter::class) var maxStudents: PositiveInteger,
) : AggregateRoot<CourseId>() {

    @Convert(converter = PositiveIntegerConverter::class)
    private var studentsCounter: PositiveInteger = PositiveInteger(0)

    @ElementCollection
    private val students: MutableSet<StudentId> = mutableSetOf()

    fun registerStudent(studentId: StudentId) {
        if (studentsCounter.value == maxStudents.value)
            throw StudentsInCourseLimitReachedException(maxStudents.value)
        studentsCounter++
        students.add(studentId)
    }

    override fun getId() = courseId

    companion object {
        fun create(name: CourseName, maxStudents: PositiveInteger) = Course(CourseId(UUID.randomUUID()), name, maxStudents)
    }
}