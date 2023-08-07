package com.subproblem.user.dto;

public record UserRequest(
        String firstname,
        String lastname,
        String email
) {
}
