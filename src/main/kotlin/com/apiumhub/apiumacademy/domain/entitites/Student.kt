package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentId.StudentId
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentName
import com.apiumhub.apiumacademy.domain.valueobjects.student.studentName.StudentNameConverter
import jakarta.persistence.Convert
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Table(name = "Students")
@Entity
class Student(
    @EmbeddedId val studentId: StudentId,
    @Convert(converter = StudentNameConverter::class) val name: StudentName
) : AggregateRoot<StudentId>() {

    override fun getId() = studentId

    companion object {
        fun create(name: StudentName) = Student(StudentId(UUID.randomUUID()), name)
    }
}