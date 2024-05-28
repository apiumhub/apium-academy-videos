package com.apiumhub.apiumacademy.domain.repositories;

import com.apiumhub.apiumacademy.domain.entitites.CourseStudent
import com.apiumhub.apiumacademy.domain.entitites.CourseStudentId
import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import org.springframework.data.jpa.repository.JpaRepository

interface CourseStudentRepository : JpaRepository<CourseStudent, CourseStudentId> {
    fun findCourseStudentByStudentIdAndCourseId(studentId: StudentId, courseId: CourseId): CourseStudent
}