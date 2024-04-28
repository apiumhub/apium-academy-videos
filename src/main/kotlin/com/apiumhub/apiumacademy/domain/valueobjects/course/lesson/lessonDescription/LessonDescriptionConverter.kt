package com.apiumhub.apiumacademy.domain.valueobjects.course.lesson.lessonDescription

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

//TODO Investigate why autoapply is not working, we should be able to remove the @Convert annotation from the entities
//TODO This should be in the infrastructure layer as it's related to persistance
@Converter(autoApply = true)
class LessonDescriptionConverter : AttributeConverter<LessonDescription, String?> {
    override fun convertToDatabaseColumn(attribute: LessonDescription?): String {
        if (null == attribute) {
            return ""
        }
        return attribute.value
    }

    override fun convertToEntityAttribute(dbData: String?): LessonDescription {
        if (null == dbData) {
            return LessonDescription("")
        }
        return LessonDescription(dbData)
    }
}