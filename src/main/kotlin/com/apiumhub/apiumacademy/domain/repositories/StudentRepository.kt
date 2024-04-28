package com.apiumhub.apiumacademy.domain.repositories

import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.exceptions.StudentNotFoundException
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, StudentId> {

    fun findStudentById(studentId: StudentId): Student =
        findById(studentId).orElseThrow { StudentNotFoundException(studentId) }
}