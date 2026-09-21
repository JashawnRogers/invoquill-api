package com.jashawnbuilds.invoquill_api.tenant.domain.membership;

import lombok.Getter;

@Getter
public class InvalidMembershipStatusException extends RuntimeException {

    private final String code;

    public InvalidMembershipStatusException(String code, String message) {
        super(message);
        this.code = code;
    }
}
