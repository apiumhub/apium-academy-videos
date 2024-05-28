package com.apiumhub.apiumacademy.domain.entitites.modules

import com.apiumhub.apiumacademy.domain.valueobjects.modules.module.ModuleId
import jakarta.persistence.*

@Entity
@Table(name = "modules")
@Embeddable
class Module(@EmbeddedId val id: ModuleId) {

    @ElementCollection
    val lessons: MutableSet<Lesson> = mutableSetOf()

    fun addLesson(lesson: Lesson) {
        lessons.add(lesson)
    }

    companion object{
        fun create() = Module(ModuleId())
    }
}