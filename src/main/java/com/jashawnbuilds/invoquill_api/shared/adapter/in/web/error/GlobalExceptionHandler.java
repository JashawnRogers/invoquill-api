package com.jashawnbuilds.invoquill_api.shared.adapter.in.web.error;

import com.jashawnbuilds.invoquill_api.identity.domain.DeletedAccountException;
import com.jashawnbuilds.invoquill_api.shared.domain.exception.InvalidDomainValueException;
import com.jashawnbuilds.invoquill_api.tenant.domain.membership.InvalidMembershipStatusException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidDomainValueException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDomainException(
            InvalidDomainValueException ex,
            HttpServletRequest httpRequest
    ) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.create(
                httpStatus.value(),
                ex.getCode(),
                ex.getMessage(),
                httpRequest.getRequestURI(),
                null
        );

        return ResponseEntity.status(httpStatus).body(apiErrorResponse);
    }

    @ExceptionHandler(DeletedAccountException.class)
    public ResponseEntity<ApiErrorResponse> handleDeletedAccountException(
            DeletedAccountException ex,
            HttpServletRequest httpRequest
    ) {
        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.create(
                status.value(),
                ex.getCode(),
                ex.getMessage(),
                httpRequest.getRequestURI(),
                null
        );

        return ResponseEntity.status(status).body(apiErrorResponse);
    }

    @ExceptionHandler(InvalidMembershipStatusException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidMembershipStatusException(
            InvalidMembershipStatusException ex,
            HttpServletRequest httpRequest
    ) {
        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.create(
                status.value(),
                ex.getCode(),
                ex.getMessage(),
                httpRequest.getRequestURI(),
                null
        );

        return ResponseEntity.status(status).body(apiErrorResponse);
    }
}
