package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseNameConverter
import com.apiumhub.apiumacademy.domain.valueobjects.course.module.moduleId.LessonId
import com.apiumhub.apiumacademy.domain.valueobjects.course.module.moduleName.LessonName
import com.apiumhub.apiumacademy.domain.valueobjects.course.module.moduleName.LessonNameConverter
import com.apiumhub.apiumacademy.domain.valueobjects.shared.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.shared.PositiveIntegerConverter
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "Courses")
class Course private constructor(
    @EmbeddedId val courseId: CourseId,
    @Convert(converter = CourseNameConverter::class) var name: CourseName,
    @Convert(converter = PositiveIntegerConverter::class) var maxRegisteredStudents: PositiveInteger,
) : AggregateRoot<CourseId>() {

    @Convert(converter = PositiveIntegerConverter::class)
    private var currentRegisteredStudents: PositiveInteger = PositiveInteger(0)

    @ElementCollection
    private val registeredStudentsIds: MutableSet<StudentId> = mutableSetOf()

    @OneToMany(fetch = FetchType.EAGER)//TODO Discuss this
    private val lessons: MutableSet<Lesson> = mutableSetOf()

    fun registerStudent(studentId: StudentId) {
        if (currentRegisteredStudents.value == maxRegisteredStudents.value) throw StudentsInCourseLimitReachedException(maxRegisteredStudents.value)
        currentRegisteredStudents++
        registeredStudentsIds.add(studentId)
    }

    fun addLesson(lesson: Lesson) {
        lessons.add(lesson)
    }

    override fun getId() = courseId

    companion object {
        fun create(name: CourseName, maxStudents: PositiveInteger) = Course(CourseId(UUID.randomUUID()), name, maxStudents)
    }
}

@Entity
@Table(name = "Lessons")
class Lesson(
    @EmbeddedId val moduleId: LessonId,
    @Convert(converter = LessonNameConverter::class) val name: LessonName
) {
    companion object {
        fun create(name: LessonName) = Lesson(LessonId(UUID.randomUUID()), name)
    }
}