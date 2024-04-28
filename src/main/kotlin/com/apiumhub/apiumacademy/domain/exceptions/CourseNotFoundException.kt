package com.apiumhub.apiumacademy.domain.exceptions

import com.apiumhub.apiumacademy.domain.valueobjects.course.courseId.CourseId

class CourseNotFoundException(id: CourseId) : RuntimeException("Course with id $id was not found") {}