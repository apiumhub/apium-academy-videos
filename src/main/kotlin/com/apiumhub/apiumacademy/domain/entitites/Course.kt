package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.entitites.modules.Module
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseNameConverter
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveIntegerConverter
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

//    @OneToMany(mappedBy = "course")
//    var courseTeachers: MutableSet<CourseTeacher> = mutableSetOf()

    @ManyToMany
    private val modules: MutableSet<Module> = mutableSetOf()

    fun registerStudent(student: Student): CourseStudent {
        TODO()
//        if (currentRegisteredStudents.value == maxRegisteredStudents.value) throw StudentsInCourseLimitReachedException(
//            maxRegisteredStudents.value
//        )
//        currentRegisteredStudents++
//        registeredStudentsIds.add(student.id)
    }

    fun removeStudent(student: Student) {
        TODO()
//        if (!registeredStudentsIds.contains(student.id)) {
//            throw StudentNotInCourseException(student.id, courseId)
//        }
//        currentRegisteredStudents--
//        registeredStudentsIds.remove(student.id)
    }

    fun isStudentRegistered(student: Student): Boolean {
        TODO()
//        return registeredStudentsIds.contains(student.id)
    }

    fun registerTeacher(teacher: Teacher) {
        TODO()
//        registeredTeacherIds.add(teacher.id)
    }

    fun removeTeacher(teacher: Teacher) {
        TODO()
//        registeredTeacherIds.remove(teacher.id)
    }

    fun isTeacherRegistered(teacher: Teacher): Boolean {
        TODO()
//        return registeredTeacherIds.contains(teacher.id)
    }

    companion object {
        fun create(name: CourseName, maxStudents: PositiveInteger) =
            Course(CourseId(), name, maxStudents)
    }
}