package com.example.demo.model.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestApiException extends RuntimeException {
    private final String apiErrorCode;
    private final HttpStatus status;

    public RestApiException(String apiErrorCode, String message, HttpStatus status) {
        super(message);
        this.apiErrorCode = apiErrorCode;
        this.status = status;
    }

    public RestApiException(String apiErrorCode, String message) {
        this(apiErrorCode, message, HttpStatus.BAD_REQUEST);
    }

    public RestApiException(String message) {
        this("9999", message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
