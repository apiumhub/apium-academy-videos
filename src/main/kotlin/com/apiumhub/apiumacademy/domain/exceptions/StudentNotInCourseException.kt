package com.apiumhub.apiumacademy.domain.exceptions

import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId

class StudentNotInCourseException(studentId: StudentId, courseId: CourseId) : RuntimeException("Student with id: ${studentId.id} is not registered in course with id: $courseId")