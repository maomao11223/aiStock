package com.example.demo.service.impl;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User register(UserRegisterRequest userRegisterRequest) {

        // 檢查email是否已存在
        Optional<User> isUserExist = userRepository.getUserByEmail(userRegisterRequest.getEmail());

        // email已被註冊過 -> 回傳前端不可重複註冊
        if (isUserExist.isPresent()) {
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //生成salt
        String salt = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 0);
        // 加密
        String encrptedPwd = Md5Utils.encrypt(userRegisterRequest.getPassword(), salt);


        User user = new User();
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(encrptedPwd);
        user.setCreatedDate(new Date());
        

        // 建立帳號
        return userRepository.save(user);
    }

    @Override
    public Integer login(UserLoginRequest userLoginRequest) {

        // 透過 getUserByEmail 檢查是否註冊過
        User user = userRepository.getUserByEmail(userLoginRequest.getEmail())
                .orElseThrow(()->new RuntimeException("找不到使用者"));

        // 未註冊
        if (user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //生成salt
        String salt = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 0);
        // 加密
        String hashedPassword = Md5Utils.encrypt(userLoginRequest.getPassword(), salt);

        // 已註冊 -> 判斷密碼是否正確
        if (user.getPassword().equals(hashedPassword)) {
            return user.getUserId();
        } else {
            log.warn("email {} 密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
