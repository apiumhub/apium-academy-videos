package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.module.lessons.request.CreateLessonRequestDto
import com.apiumhub.apiumacademy.application.dto.module.lessons.response.CourseLessonResponseDto
import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.dto.course.response.CourseResponseDto
import com.apiumhub.apiumacademy.application.dto.course.response.toCourseDto
import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CourseService(
    private val studentRepository: StudentRepository, private val courseRepository: CourseRepository
) {
    fun findById(id: String): CourseResponseDto? = courseRepository.findById(CourseId(id)).getOrNull()?.toCourseDto()

    fun findAll() = courseRepository.findAll().map { it.toCourseDto() }

    fun insert(course: CreateCourseRequestDto) =
        courseRepository.save(
            Course.create(
                CourseName(course.name), PositiveInteger(course.maxStudents)
            )
        ).toCourseDto()

    fun registerStudentInCourse(courseId: String, studentId: String) {
        val student = studentRepository.findStudentById(StudentId(studentId))
        val course = courseRepository.findCourseById(CourseId(courseId))
        course.registerStudent(student)
        courseRepository.save(course)
    }

    fun removeStudentFromCourse(courseId: String, studentId: String) {
        val student = studentRepository.findStudentById(StudentId(studentId))
        val course = courseRepository.findCourseById(CourseId(courseId))
        course.removeStudent(student)
        courseRepository.save(course)
    }

    fun addLessonToCourse(courseId: String, lesson: CreateLessonRequestDto) {
        TODO()
//        val course = courseRepository.findCourseById(CourseId(courseId))
//        course.addLesson(Lesson.create(LessonName(lesson.name), LessonDescription(lesson.description)))
//        courseRepository.save(course)
    }

    fun getCourseLessons(courseId: String): List<CourseLessonResponseDto> {
        TODO()
//        val course = courseRepository.findCourseById(CourseId(courseId))
//        return course.lessons.map { it.toCourseLessonDto() }
    }
}