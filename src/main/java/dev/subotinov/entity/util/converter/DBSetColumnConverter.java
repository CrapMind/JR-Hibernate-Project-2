package dev.subotinov.entity.util.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = true)
@AllArgsConstructor
public class DBSetColumnConverter<T extends Enum<T>> implements AttributeConverter<Set<T>, String> {

    private final Class<T> enumClass;

    @Override
    public String convertToDatabaseColumn(Set<T> attribute) {
        if (attribute == null || attribute.isEmpty()) return "";
        return attribute.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<T> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return EnumSet.noneOf(enumClass);
        return Arrays.stream(dbData.split(","))
                .map(String::trim)
                .map(name -> Enum.valueOf(enumClass, name))
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(enumClass)));
    }
}
