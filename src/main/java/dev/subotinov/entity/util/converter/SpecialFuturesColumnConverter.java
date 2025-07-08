package dev.subotinov.entity.util.converter;

import dev.subotinov.entity.util.enums.SpecialFutures;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SpecialFuturesColumnConverter extends DBSetColumnConverter<SpecialFutures> {

    public SpecialFuturesColumnConverter(Class<SpecialFutures> enumClass) {
        super(enumClass);
    }
}
