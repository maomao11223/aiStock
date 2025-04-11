package com.example.demo.controller;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.model.common.ApiRestResponse;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @Operation(summary = "註冊")
    public ApiRestResponse<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {

        User user = userService.register(userRegisterRequest);


        return ApiRestResponse.success(user);
    }

    @PostMapping("/login")
    @Operation(summary = "登入")
    public ApiRestResponse<LoginResponse> login(
            @RequestBody @Valid UserLoginRequest userLoginRequest
    ) {

        Integer userId = userService.login(userLoginRequest);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(userId);
        loginResponse.setToken("123123");
        return ApiRestResponse.success(loginResponse);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "取得登入者資料")
    public ApiRestResponse<User> getUserDetail(
            @PathVariable String userId
    ) {
        User user = new User();
        user.setUserId(1);
        user.setEmail("123@asdf.sdf");
        return ApiRestResponse.success(user);
    }
}
