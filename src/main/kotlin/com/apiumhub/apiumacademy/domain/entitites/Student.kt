package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import jakarta.persistence.Convert
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Table(name = "Students")
@Entity
class Student private constructor(
    @EmbeddedId val studentId: StudentId, @Embedded val name: StudentName
) : AggregateRoot<StudentId>() {

    companion object {
        fun create(name: StudentName) = Student(StudentId(UUID.randomUUID()), name)
    }
}