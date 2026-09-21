package com.jashawnbuilds.invoquill_api.shared.adapter.in.web.error;

import com.jashawnbuilds.invoquill_api.shared.domain.exception.InvalidDomainValueException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

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
}
