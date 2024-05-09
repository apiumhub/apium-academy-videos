package com.apiumhub.apiumacademy.domain.entitites.modules

import com.apiumhub.apiumacademy.domain.valueobjects.modules.module.ModuleId
import jakarta.persistence.*

@Entity
@Table(name = "modules")
class Module(@EmbeddedId val id: ModuleId) {

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])//TODO Discuss EAGER fetch
    val lessons: MutableSet<Lesson> = mutableSetOf()

    fun addLesson(lesson: Lesson) {
        lessons.add(lesson)
    }

    companion object{
        fun create() = Module(ModuleId())
    }
}