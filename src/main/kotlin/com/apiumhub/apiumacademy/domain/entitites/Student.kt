package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.Email
import com.apiumhub.apiumacademy.domain.valueobjects.shared.email.EmailConverter
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentNameConverter
import jakarta.persistence.Convert
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "Students")
@Entity
class Student private constructor(
    @EmbeddedId val studentId: StudentId,
    @Convert(converter = StudentNameConverter::class) val name: StudentName,
    @Convert(converter = EmailConverter::class) val email: Email
) : AggregateRoot<StudentId>() {

    override fun getId() = studentId

    companion object {
        fun create(name: StudentName, email: Email) = Student(StudentId(), name, email)
    }
}