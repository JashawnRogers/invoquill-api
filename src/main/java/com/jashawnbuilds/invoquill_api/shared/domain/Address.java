package com.jashawnbuilds.invoquill_api.shared.domain;

import com.jashawnbuilds.invoquill_api.shared.domain.exception.InvalidDomainValueException;

public record Address(
        String streetLine1,
        String streetLine2,
        String city,
        String state,
        String postalCode,
        String country
) {
    public Address {
        if (streetLine1 == null || streetLine1.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_STREET_LINE",
                    "Street line 1 cannot be empty."
            );

        if (city == null || city.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_CITY",
                    "City cannot be empty."
            );

        if (postalCode == null || postalCode.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_POSTAL_CODE",
                    "Postal code cannot be empty."
            );

        if (country == null || country.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_COUNTRY",
                    "Country cannot be empty."
            );
    }

    public String toFormattedMultiLineAddress() {
        String line2 = (streetLine2 != null && !streetLine2.isBlank()) ? streetLine2 + "\n" : "";
        return String.format("%s\n%s%s, %s %s\n%s",
                streetLine1, line2, city, state, postalCode, country
        );
    }
}
