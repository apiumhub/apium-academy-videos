package com.apiumhub.apiumacademy.domain.exceptions

import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId

class StudentNotFoundException(id: StudentId) : RuntimeException("Student with id: ${id.id} could not be found")