package dev.subotinov.entity.util.converter;

import dev.subotinov.entity.util.enums.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingColumnConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Rating.fromDbValue(dbData);
    }
}
