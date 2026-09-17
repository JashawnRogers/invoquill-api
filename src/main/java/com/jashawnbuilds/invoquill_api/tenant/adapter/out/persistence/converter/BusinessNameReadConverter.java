package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.BusinessName;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class BusinessNameReadConverter implements Converter<String, BusinessName> {

    @Override
    public BusinessName convert(String source) {
        if (source == null) return null;
        return BusinessName.of(source);
    }
}