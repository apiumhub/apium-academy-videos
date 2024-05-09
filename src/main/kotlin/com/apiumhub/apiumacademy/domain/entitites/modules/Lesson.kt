package com.apiumhub.apiumacademy.domain.entitites.modules

import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonDescription.LessonDescription
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonDescription.LessonDescriptionConverter
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonId.LessonId
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonName.LessonName
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonName.LessonNameConverter
import jakarta.persistence.Convert
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "Lessons")
class Lesson(
    @EmbeddedId val id: LessonId,
    @Convert(converter = LessonNameConverter::class) val name: LessonName,
    @Convert(converter = LessonDescriptionConverter::class) val description: LessonDescription
) {
    companion object {
        fun create(name: LessonName, description: LessonDescription) =
            Lesson(LessonId(), name, description)
    }
}