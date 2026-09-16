package com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter;

import com.jashawnbuilds.invoquill_api.shared.domain.UsPhoneNumber;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class UsPhoneNumberWriteConverter implements Converter<UsPhoneNumber, String> {

    @Override
    public String convert(UsPhoneNumber source) {
        return UsPhoneNumber.generateString(source);
    }
}
