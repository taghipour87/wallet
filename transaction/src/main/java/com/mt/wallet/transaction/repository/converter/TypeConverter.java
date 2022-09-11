package com.mt.wallet.transaction.repository.converter;

import com.mt.wallet.transaction.model.entity.Type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Type type) {
        return type.fromValue(type);
    }

    @Override
    public Type convertToEntityAttribute(Integer code) {
        return Type.valueOf(code);
    }

}