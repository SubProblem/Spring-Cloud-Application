package com.subproblem.user.dto;

import java.util.List;

public record UserResponseWithProducts(
        Integer id,
        String firstname,
        String lastname,
        String email,
        List<Product> products
) {
}
