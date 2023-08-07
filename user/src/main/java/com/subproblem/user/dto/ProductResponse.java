package com.subproblem.user.dto;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        String price
) {
}
