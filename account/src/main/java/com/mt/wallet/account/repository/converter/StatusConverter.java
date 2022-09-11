package com.mt.wallet.account.repository.converter;

import com.mt.wallet.account.model.entity.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status.fromValue(status);
    }

    @Override
    public Status convertToEntityAttribute(Integer code) {
        return Status.valueOf(code);
    }
 
}