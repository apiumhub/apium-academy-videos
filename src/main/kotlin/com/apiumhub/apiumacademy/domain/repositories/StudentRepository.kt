package com.apiumhub.apiumacademy.domain.repositories

import com.apiumhub.apiumacademy.domain.entitites.Student
import com.apiumhub.apiumacademy.domain.exceptions.StudentNotFoundException
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, StudentId> {

    fun findStudentByStudentId(studentId: StudentId): Student =
        findById(studentId).orElseThrow { StudentNotFoundException(studentId) }
}