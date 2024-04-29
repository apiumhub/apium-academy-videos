package com.apiumhub.apiumacademy.domain.valueobjects.student.studentName

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

//TODO Investigate why autoapply is not working, we should be able to remove the @Convert annotation from the entities
//TODO This should be in the infrastructure layer as it's related to persistance
@Converter(autoApply = true)
class StudentNameConverter : AttributeConverter<StudentName, String?> {
    override fun convertToDatabaseColumn(attribute: StudentName?) =
        attribute?.value.orEmpty()

    override fun convertToEntityAttribute(dbData: String?) =
        StudentName(dbData.orEmpty())
}