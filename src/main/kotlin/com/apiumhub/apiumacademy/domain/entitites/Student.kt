package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.AggregateRoot
import com.apiumhub.apiumacademy.domain.valueobjects.EntityId
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Embeddable
class StudentId(override val id: UUID): EntityId()

@Table(name="Students")
@Entity
class Student (override val id: StudentId, val name: String): AggregateRoot<StudentId>(id){
    companion object{
        fun create(name: String) = Student(StudentId(UUID.randomUUID()), name)
    }
}