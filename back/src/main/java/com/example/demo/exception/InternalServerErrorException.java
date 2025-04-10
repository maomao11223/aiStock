package com.example.demo.exception;

import com.example.demo.model.common.RestApiException;
import org.springframework.http.HttpStatus;

/**
 * 系統內部錯誤用的自訂例外
 */
public class InternalServerErrorException extends RestApiException {

    public InternalServerErrorException(String message) {
        super("5000", message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super("5000", message, HttpStatus.INTERNAL_SERVER_ERROR);
        this.initCause(cause);
    }
}
