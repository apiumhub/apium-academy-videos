package com.apiumhub.apiumacademy.domain.valueobjects.user.password

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class PasswordConverter : AttributeConverter<Password, String?> {
    override fun convertToDatabaseColumn(attribute: Password?) =
        attribute?.value.orEmpty()

    override fun convertToEntityAttribute(dbData: String?) =
        Password.withEncodedPassword(dbData.orEmpty())
}