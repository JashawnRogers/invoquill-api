package com.jashawnbuilds.invoquill_api.identity.domain;

import lombok.Getter;

@Getter
public class DeletedAccountException extends RuntimeException {

    private String code;

    public DeletedAccountException(String code, String message) {
        super(message);
        this.code = code;
    }
}
