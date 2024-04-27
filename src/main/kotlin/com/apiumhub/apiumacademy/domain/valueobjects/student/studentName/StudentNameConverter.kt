package com.apiumhub.apiumacademy.domain.valueobjects.student.studentName

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class StudentNameConverter : AttributeConverter<StudentName, String?> {
    override fun convertToDatabaseColumn(attribute: StudentName?): String {
        if (null == attribute) {
            return ""
        }
        return attribute.value
    }

    override fun convertToEntityAttribute(dbData: String?): StudentName {
        if (null == dbData) {
            return StudentName("")
        }
        return StudentName(dbData)
    }
}