package com.apiumhub.apiumacademy.domain.valueobjects.shared

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class PositiveIntegerConverter : AttributeConverter<PositiveInteger, Int?> {
    override fun convertToDatabaseColumn(attribute: PositiveInteger?): Int {
        if (null == attribute) {
            return 0
        }
        return attribute.value
    }

    override fun convertToEntityAttribute(dbData: Int?): PositiveInteger {
        if (null == dbData) {
            return PositiveInteger(0)
        }
        return PositiveInteger(dbData)
    }
}