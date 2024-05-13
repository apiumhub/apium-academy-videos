package com.apiumhub.apiumacademy.domain.entitites.modules

import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonDescription.LessonDescription
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonDescription.LessonDescriptionConverter
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonId.LessonId
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonName.LessonName
import com.apiumhub.apiumacademy.domain.valueobjects.modules.lesson.lessonName.LessonNameConverter
import jakarta.persistence.*

@Entity
@Table(name = "Lessons")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Lesson(
    @EmbeddedId open val id: LessonId,
    @Convert(converter = LessonNameConverter::class) open val name: LessonName,
    @Convert(converter = LessonDescriptionConverter::class) open val description: LessonDescription
) {
    companion object {
        fun create(name: LessonName, description: LessonDescription) =
            TutoredLesson(LessonId(), name, description)
    }
}

@Entity
@Table(name = "Lessons_SelfAssessable")
class SelfAssessableLesson(id: LessonId, name: LessonName, description: LessonDescription) :
    Lesson(id, name, description) {
    val foo: String = "Foo"
}

@Entity
@Table(name = "Lessons_Tutored")
class TutoredLesson(id: LessonId, name: LessonName, description: LessonDescription) : Lesson(id, name, description) {
    val bar: String = "Bar"
}

@Entity
@Table(name = "Lesson_NoExam")
class NoExamLesson(id: LessonId, name: LessonName, description: LessonDescription) : Lesson(id, name, description)