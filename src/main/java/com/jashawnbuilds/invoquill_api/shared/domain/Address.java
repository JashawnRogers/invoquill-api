package com.jashawnbuilds.invoquill_api.shared.domain;

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
            throw new RuntimeException();

        if (city == null || city.isBlank())
            throw new RuntimeException();

        if (postalCode == null || postalCode.isBlank())
            throw new RuntimeException();

        if (country == null || country.isBlank())
            throw new RuntimeException();
    }

    public String toFormattedMultiLineAddress() {
        String line2 = (streetLine2 != null && !streetLine2.isBlank()) ? streetLine2 + "\n" : "";
        return String.format("%s\n%s%s, %s %s\n%s",
                streetLine1, line2, city, state, postalCode, country
        );
    }
}
