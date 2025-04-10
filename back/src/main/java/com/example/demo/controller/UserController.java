package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/register")
    @Operation(summary = "註冊")
    public void register(){}

    @PostMapping("/login")
    @Operation(summary = "登入")
    public void login(){}

    @GetMapping("/{userId}")
    @Operation(summary = "取得登入者資料")
    public void getUserDetail(){}
}
