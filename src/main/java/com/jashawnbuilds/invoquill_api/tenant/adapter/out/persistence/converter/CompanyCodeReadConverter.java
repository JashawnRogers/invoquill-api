package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.tenant.domain.CompanyCode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class CompanyCodeReadConverter implements Converter<String, CompanyCode> {
    @Override
    public CompanyCode convert(String source) {
        if (source == null) return null;
        return CompanyCode.fromExisting(source);
    }
}
