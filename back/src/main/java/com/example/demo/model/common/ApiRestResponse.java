package com.example.demo.model.common;

import lombok.Data;

@Data
public class ApiRestResponse<T> {
    private String returnCode;
    private String message;
    private boolean apiStatus;
    private int status;
    private String apiErrorMsg;
    private T data;
    public static <T> ApiRestResponse<T> success(T data) {
        ApiRestResponse<T> res = new ApiRestResponse<>();
        res.setReturnCode("0000");
        res.setMessage("成功");
        res.setApiStatus(true);
        res.setData(data);
        res.setStatus(200);
        return res;
    }

    public static <T> ApiRestResponse<T> failure(String returnCode, String message, String apiErrorMsg) {
        ApiRestResponse<T> res = new ApiRestResponse<>();
        res.setReturnCode(returnCode);
        res.setMessage(message);
        res.setApiErrorMsg(apiErrorMsg);
        res.setApiStatus(false);
        res.setStatus(400);
        return res;
    }

}
