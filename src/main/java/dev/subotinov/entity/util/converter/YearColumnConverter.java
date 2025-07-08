package dev.subotinov.entity.util.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;
@Converter(autoApply = false)

public class YearColumnConverter implements AttributeConverter<Year, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Year attribute) {
        if (attribute == null) return null;
        int year = attribute.getValue();
        if (year < 1900 || year > 2100) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
        return year;
    }

    @Override
    public Year convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        if (dbData < 1900 || dbData > 2100) {
            throw new IllegalArgumentException("Invalid year from DB: " + dbData);
        }
        return Year.of(dbData);
    }

}
