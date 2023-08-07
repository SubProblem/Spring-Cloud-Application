package com.subproblem.user.controller;


import com.subproblem.user.dto.ProductRequest;
import com.subproblem.user.dto.UserRequest;
import com.subproblem.user.dto.UserResponse;
import com.subproblem.user.dto.UserResponseWithProducts;
import com.subproblem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<UserResponse> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequest request) {
        return userService.addUser(request);
    }

    @GetMapping("/{userId}/products")
    public UserResponseWithProducts getUserWithProducts(@PathVariable("userId") Integer userId) {
        return userService.getUserWithProducts(userId);
    }


    @PostMapping("/{userId}/product")
    public ResponseEntity<?> addProduct(@PathVariable("userId") Integer userId, @RequestBody ProductRequest request) {
        return userService.addProduct(userId, request);
    }
}
