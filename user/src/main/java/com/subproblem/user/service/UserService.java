package com.subproblem.user.service;


import com.subproblem.user.client.ProductClient;
import com.subproblem.user.dto.*;
import com.subproblem.user.entity.User;
import com.subproblem.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProductClient productClient;

    public List<UserResponse> getAllUsers() {

        var users = userRepository.findAll();

        return users.stream()
                .map(this::convertToUserDto)
                .toList();
    }

    public ResponseEntity<?> addUser(UserRequest request) {

        var user = User.builder()
                .email(request.email())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .build();

        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }



    public UserResponseWithProducts getUserWithProducts(Integer id) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        List<Product> products = productClient.getAllProductForUser(id);

        return new UserResponseWithProducts(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                products
        );
    }


    private UserResponse convertToUserDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );

    }

    public ResponseEntity<?> addProduct(Integer userId, ProductRequest request) {

        var user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        productClient.addProductForUser(userId, request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
