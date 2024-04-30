package com.apiumhub.apiumacademy.domain.valueobjects.shared.positiveInteger

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class PositiveIntegerConverter : AttributeConverter<PositiveInteger, Int?> {
    override fun convertToDatabaseColumn(attribute: PositiveInteger?) =
        attribute?.value ?: 0

    override fun convertToEntityAttribute(dbData: Int?) =
        PositiveInteger(dbData ?: 0)
}