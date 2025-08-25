package dev.subotinov.util.converter;

import dev.subotinov.util.enums.SpecialFeatures;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class SpecialFeaturesColumnConverter implements AttributeConverter<Set<SpecialFeatures>, String> {

    @Override
    public String convertToDatabaseColumn(Set<SpecialFeatures> attribute) {
        if (attribute == null || attribute.isEmpty()) return "";
        return attribute.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<SpecialFeatures> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return EnumSet.noneOf(SpecialFeatures.class);
        return Arrays.stream(dbData.split(","))
                .map(String::trim)
                .map(name -> name.toUpperCase().replace(" ", "_"))
                .map(name -> Enum.valueOf(SpecialFeatures.class, name))
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(SpecialFeatures.class)));
    }
}

