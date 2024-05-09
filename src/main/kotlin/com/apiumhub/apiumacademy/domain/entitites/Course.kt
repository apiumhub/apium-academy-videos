package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.entitites.modules.Module
import com.apiumhub.apiumacademy.domain.exceptions.StudentNotInCourseException
import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseNameConverter
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveIntegerConverter
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherId.TeacherId
import jakarta.persistence.*

@Entity
@Table(name = "Courses")
class Course private constructor(
    @EmbeddedId val courseId: CourseId,
    @Convert(converter = CourseNameConverter::class) var name: CourseName,
    @Convert(converter = PositiveIntegerConverter::class) var maxRegisteredStudents: PositiveInteger,
) : AggregateRoot<Course, CourseId>() {

    @Convert(converter = PositiveIntegerConverter::class)
    private var currentRegisteredStudents: PositiveInteger = PositiveInteger(0)

    @ElementCollection
    private val registeredStudentsIds: MutableSet<StudentId> = mutableSetOf()

    @ElementCollection
    private val registeredTeacherIds: MutableSet<TeacherId> = mutableSetOf()

    @ManyToMany
    private val modules: MutableSet<Module> = mutableSetOf()

    fun registerStudent(student: Student) {
        if (currentRegisteredStudents.value == maxRegisteredStudents.value) throw StudentsInCourseLimitReachedException(
            maxRegisteredStudents.value
        )
        currentRegisteredStudents++
        registeredStudentsIds.add(student.id)
    }

    fun removeStudent(student: Student) {
        if (!registeredStudentsIds.contains(student.id)) {
            throw StudentNotInCourseException(student.id, courseId)
        }
        currentRegisteredStudents--
        registeredStudentsIds.remove(student.id)
    }

    fun isStudentRegistered(student: Student): Boolean {
        return registeredStudentsIds.contains(student.id)
    }

    fun registerTeacher(teacher: Teacher) {
        registeredTeacherIds.add(teacher.id)
    }

    fun removeTeacher(teacher: Teacher) {
        registeredTeacherIds.remove(teacher.id)
    }

    fun isTeacherRegistered(teacher: Teacher): Boolean {
        return registeredTeacherIds.contains(teacher.id)
    }

    override fun getId() = courseId

    companion object {
        fun create(name: CourseName, maxStudents: PositiveInteger) =
            Course(CourseId(), name, maxStudents)
    }
}