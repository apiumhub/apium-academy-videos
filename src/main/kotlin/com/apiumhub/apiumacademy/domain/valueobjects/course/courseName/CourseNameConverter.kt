package com.apiumhub.apiumacademy.domain.valueobjects.course.courseName

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class CourseNameConverter: AttributeConverter<CourseName, String?> {
    override fun convertToDatabaseColumn(attribute: CourseName?): String {
        if (null == attribute) {
            return ""
        }
        return attribute.value
    }

    override fun convertToEntityAttribute(dbData: String?): CourseName {
        if (null == dbData) {
            return CourseName("")
        }
        return CourseName(dbData)
    }
}