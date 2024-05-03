package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.user.userId.UserId
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "Students")
@Entity
class Student private constructor(
    @EmbeddedId val studentId: StudentId
) : AggregateRoot<Student, StudentId>() {

    override fun getId() = studentId

    companion object {
        fun create() = Student(StudentId())
        fun createFromUser(userId: UserId) = Student(StudentId(userId.id))
    }
}