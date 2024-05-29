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
) : AggregateRoot<CourseId>() {

    @Convert(converter = PositiveIntegerConverter::class)
    private var currentRegisteredStudents: PositiveInteger = PositiveInteger(0)

    @ElementCollection
    private val registeredStudentsIds: MutableSet<StudentId> = mutableSetOf()

    @ElementCollection
    private val registeredTeacherIds: MutableSet<TeacherId> = mutableSetOf()

    @ElementCollection
    private val modules: MutableSet<Module> = mutableSetOf()

    fun registerStudent(student: Student): Pair<Course, CourseStudent> {
        if (currentRegisteredStudents.value == maxRegisteredStudents.value)
            throw StudentsInCourseLimitReachedException(maxRegisteredStudents.value)
        currentRegisteredStudents++
        registeredStudentsIds.add(student.studentId)
        return Pair(this, CourseStudent.create(this, student))
    }

    fun removeStudent(student: Student): Course {
        if (!isStudentRegistered(student)) throw StudentNotInCourseException(student.studentId, courseId)
        currentRegisteredStudents--
        registeredStudentsIds.remove(student.studentId)
        return this
    }

    fun isStudentRegistered(student: Student): Boolean {
        return registeredStudentsIds.contains(student.studentId)
    }

    fun registerTeacher(teacher: Teacher) : Course {
        registeredTeacherIds.add(teacher.teacherId)
        return this
    }

    fun removeTeacher(teacher: Teacher) : Course {
        registeredTeacherIds.remove(teacher.teacherId)
        return this
    }

    fun isTeacherRegistered(teacher: Teacher): Boolean {
        return registeredTeacherIds.contains(teacher.teacherId)
    }

    companion object {
        fun create(name: CourseName, maxStudents: PositiveInteger) = Course(CourseId(), name, maxStudents)
    }
}