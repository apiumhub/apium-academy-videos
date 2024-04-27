package com.apiumhub.apiumacademy.domain.exceptions

class StudentsInCourseLimitReachedException(maxStudents: Int) : RuntimeException("Max number of students in course: $maxStudents")