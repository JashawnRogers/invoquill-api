package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.BusinessName;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class BusinessNameWriteConverter implements Converter<BusinessName, String> {
    @Override
    public String convert(BusinessName source) {
        return source.value();
    }
}
