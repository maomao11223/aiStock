package com.example.demo.model.common;

import org.springframework.http.HttpStatus;
import java.util.List;

public class ApiError {
    private HttpStatus status;
    private String apiErrorCode;    // API錯誤代碼
    private String message;         // 錯誤訊息
    private List<String> errors;    // 詳細錯誤訊息

    // Constructor, getters, setters
    public ApiError(HttpStatus status, String apiErrorCode, String message, List<String> errors) {
        this.status = status;
        this.apiErrorCode = apiErrorCode;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getApiErrorCode() {
        return apiErrorCode;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}
