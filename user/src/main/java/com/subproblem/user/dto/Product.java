package com.subproblem.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private BigDecimal price;
}
