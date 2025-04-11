package com.example.demo.repository;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select user_id, email, password, created_date from users where email = :email", nativeQuery = true)
    Optional<User> getUserByEmail(@NotBlank @Email String email);

}
