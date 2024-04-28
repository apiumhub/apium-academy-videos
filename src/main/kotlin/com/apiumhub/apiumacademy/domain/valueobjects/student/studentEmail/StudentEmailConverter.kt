package com.apiumhub.apiumacademy.domain.valueobjects.student.studentEmail

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

//TODO Investigate why autoapply is not working, we should be able to remove the @Convert annotation from the entities
//TODO This should be in the infrastructure layer as it's related to persistance
@Converter(autoApply = true)
class StudentEmailConverter : AttributeConverter<StudentEmail, String?> {
    override fun convertToDatabaseColumn(attribute: StudentEmail?): String {
        if (null == attribute) {
            return ""
        }
        return attribute.value
    }

    override fun convertToEntityAttribute(dbData: String?): StudentEmail {
        if (null == dbData) {
            return StudentEmail("")
        }
        return StudentEmail(dbData)
    }
}