package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.tenant.converter;

import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.CompanyCode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class CompanyCodeWriteConverter implements Converter<CompanyCode, String> {
    @Override
    public String convert(CompanyCode source) {
        return source.value();
    }
}
