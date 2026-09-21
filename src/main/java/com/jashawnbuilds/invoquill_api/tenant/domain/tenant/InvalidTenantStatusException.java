package com.jashawnbuilds.invoquill_api.tenant.domain.tenant;

import lombok.Getter;

@Getter
public class InvalidTenantStatusException extends RuntimeException {

    private final String code;

    public InvalidTenantStatusException(String code, String message) {
        super(message);
        this.code = code;
    }
}
