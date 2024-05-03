package com.apiumhub.apiumacademy.domain.entitites

import com.apiumhub.apiumacademy.domain.valueobjects.teacher.teacherId.TeacherId
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "Teachers")
@Entity
class Teacher private constructor(
    @EmbeddedId val teacherId: TeacherId,
) : AggregateRoot<Teacher, TeacherId>() {
    override fun getId(): TeacherId = teacherId

    companion object {
        fun create() = Teacher(TeacherId())
    }
}