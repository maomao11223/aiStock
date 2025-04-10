package com.example.demo.handler;


import com.example.demo.model.common.ApiRestResponse;
import com.example.demo.model.common.RestApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // 處理 RestApiException
    @ExceptionHandler(RestApiException.class)
    public ResponseEntity<ApiRestResponse<?>> handleRestApiException(RestApiException ex) {
        log.error("RestApiException 被攔截: {}", ex.getMessage());

        ApiRestResponse<?> response = ApiRestResponse.failure(
                ex.getApiErrorCode(),
                ex.getMessage(),
                ex.getMessage()
        );

        return ResponseEntity
                .status(ex.getStatus())
                .body(response);
    }

    // 處理其他未預期例外
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiRestResponse<?>> handleOtherExceptions(Exception ex) {
        log.error("系統發生未處理的例外: {}", ex.getMessage(), ex);

        ApiRestResponse<?> response = ApiRestResponse.failure(
                "9999",
                "系統發生錯誤，請聯絡管理員",
                ex.getMessage()
        );

        return ResponseEntity
                .status(500)
                .body(response);
    }
}
