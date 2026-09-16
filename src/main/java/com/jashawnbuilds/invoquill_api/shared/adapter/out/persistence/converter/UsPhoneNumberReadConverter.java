package com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.shared.domain.UsPhoneNumber;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class UsPhoneNumberReadConverter implements Converter<String, UsPhoneNumber> {

    @Override
    public UsPhoneNumber convert(String source) {
        return UsPhoneNumber.of(source);
    }
}
