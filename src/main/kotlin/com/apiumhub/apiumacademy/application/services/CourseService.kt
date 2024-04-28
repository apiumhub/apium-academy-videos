package com.apiumhub.apiumacademy.application.services

import com.apiumhub.apiumacademy.application.dto.course.lessons.request.CreateLessonRequestDto
import com.apiumhub.apiumacademy.application.dto.course.lessons.response.CourseLessonResponseDto
import com.apiumhub.apiumacademy.application.dto.course.request.CreateCourseRequestDto
import com.apiumhub.apiumacademy.application.dto.course.response.CourseResponseDto
import com.apiumhub.apiumacademy.domain.entitites.Course
import com.apiumhub.apiumacademy.domain.entitites.Lesson
import com.apiumhub.apiumacademy.domain.repositories.CourseRepository
import com.apiumhub.apiumacademy.domain.repositories.StudentRepository
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseName.CourseName
import com.apiumhub.apiumacademy.domain.valueobjects.course.lesson.lessonDescription.LessonDescription
import com.apiumhub.apiumacademy.domain.valueobjects.course.lesson.lessonName.LessonName
import com.apiumhub.apiumacademy.domain.valueobjects.shared.PositiveInteger
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class CourseService(
    private val studentRepository: StudentRepository, private val courseRepository: CourseRepository
) {
    fun findById(id: String): CourseResponseDto? = courseRepository.findById(CourseId(UUID.fromString(id))).map { CourseResponseDto.from(it) }.getOrNull()

    fun findAll() = courseRepository.findAll().map { CourseResponseDto.from(it) }

    fun insert(course: CreateCourseRequestDto) = CourseResponseDto.from(
        courseRepository.save(
            Course.create(
                CourseName(course.name), PositiveInteger(course.maxStudents)
            )
        )
    )

    fun registerStudentInCourse(courseId: String, studentId: String) {
        val student = studentRepository.findStudentById(StudentId(studentId))
        val course = courseRepository.findCourseById(CourseId(courseId))
        course.registerStudent(student.id)
        courseRepository.save(course)
    }

    fun addLessonToCourse(courseId: String, lesson: CreateLessonRequestDto) {
        val course = courseRepository.findCourseById(CourseId(courseId))
        course.addLesson(Lesson.create(LessonName(lesson.name), LessonDescription(lesson.description)))
        courseRepository.save(course)
    }

    fun getCourseLessons(courseId: String): List<CourseLessonResponseDto> {
        val course = courseRepository.findCourseById(CourseId(courseId))
        return course.lessons.map { CourseLessonResponseDto.from(it) }
    }
}