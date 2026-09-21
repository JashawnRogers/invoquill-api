package com.jashawnbuilds.invoquill_api.shared.domain.exception;

import lombok.Getter;

/**
 * The {@code InvalidDomainValueException} object is a shared object intended to be used for repetitive
 * null or blank checks when creating domain objects.
 */
@Getter
public class InvalidDomainValueException extends RuntimeException {

    private final String code;

    /**
     * @param code
     *        An API specific error code aiming to provide context of the error to the client.
     *        Ex: 409 Conflict -> EMAIL_ALREADY_EXISTS
     * @param message
     *        A human-readable explanation specific to this occurrence of the problem.
     */
    public InvalidDomainValueException(String code, String message) {
        super(message);
        this.code = code;
    }
}
