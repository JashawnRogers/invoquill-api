package com.jashawnbuilds.invoquill_api.shared.domain;

import com.jashawnbuilds.invoquill_api.shared.domain.exception.InvalidDomainValueException;

import java.util.regex.Pattern;

public record EmailAddress(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    public EmailAddress {
        if (value == null || value.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_EMAIL",
                    "Email cannot be empty."
            );

        value = value.toLowerCase().strip();

        if (!EMAIL_PATTERN.matcher(value).matches())
            throw new RuntimeException();
    }

    public static EmailAddress of(String value) {
        return new EmailAddress(value);
    }

    @Override
    public String toString() {
        return "[email=" + value +"]";
    }
}
