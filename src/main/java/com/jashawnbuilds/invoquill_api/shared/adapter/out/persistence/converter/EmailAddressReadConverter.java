package com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class EmailAddressReadConverter implements Converter<String, EmailAddress> {
    @Override
    public EmailAddress convert(String source) {
        if (source == null) return null;
        return EmailAddress.of(source);
    }
}
