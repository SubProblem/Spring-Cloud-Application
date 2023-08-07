package com.subproblem.user.dto;


public record UserResponse(
        Integer id,
        String firstname,
        String lastname,
        String email
) {
}
