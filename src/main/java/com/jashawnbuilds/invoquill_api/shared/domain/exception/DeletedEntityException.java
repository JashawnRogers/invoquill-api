package com.jashawnbuilds.invoquill_api.shared.domain.exception;

import lombok.Getter;

@Getter
public class DeletedEntityException extends RuntimeException {

    private String code;

    public DeletedEntityException(String code, String message) {
        super(message);
        this.code = code;
    }
}
