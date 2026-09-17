package com.jashawnbuilds.invoquill_api.tenant.domain.tenant;

public record BusinessName(String value) {

    public BusinessName {
        if (value == null || value.isBlank())
            throw new RuntimeException();

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
