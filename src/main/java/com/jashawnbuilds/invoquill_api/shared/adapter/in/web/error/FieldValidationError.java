package com.jashawnbuilds.invoquill_api.shared.adapter.in.web.error;


/**
 * The {@code FieldValidationError} is intended to allow controller DTO validation
 * to cleanly integrate with the {@code ApiErrorResponse} object that follows {@code RFC 9457}.
 * The {@code FieldValidationError} is nullable as every {@code ApiErrorResponse} instance does not
 * require a field.
 * @param field
 *        Instead of @NotBlank || @Email -> use field value
 * @param message
 *        A human-readable description of error pertaining to field.
 * @see ApiErrorResponse
 */
public record FieldValidationError(
        String field,
        String message
) {
}
