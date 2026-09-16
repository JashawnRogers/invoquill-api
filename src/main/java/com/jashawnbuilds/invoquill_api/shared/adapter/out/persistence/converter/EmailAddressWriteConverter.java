package com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class EmailAddressWriteConverter implements Converter<EmailAddress, String> {

    @Override
    public String convert(EmailAddress source) {
        return source.value();
    }
}
