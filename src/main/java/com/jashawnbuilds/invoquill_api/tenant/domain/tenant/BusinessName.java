package com.jashawnbuilds.invoquill_api.tenant.domain.tenant;

import com.jashawnbuilds.invoquill_api.shared.domain.exception.InvalidDomainValueException;

public record BusinessName(String value) {

    public BusinessName {
        if (value == null || value.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_BUSINESS_NAME",
                    "Business name cannot be empty."
            );

        value = value.strip();

        if (value.length() >= 10)
            throw new RuntimeException();
    }

    public static BusinessName of(String existingBusinessName) {
        return new BusinessName(existingBusinessName);
    }
    @Override
    public String toString() {
        return "[BusinessName=" + value +"]";
    }
}
