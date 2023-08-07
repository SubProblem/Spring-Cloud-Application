package com.subproblem.product.controller;

import com.subproblem.product.dto.ProductRequest;
import com.subproblem.product.dto.ProductResponse;
import com.subproblem.product.entity.Product;
import com.subproblem.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    // HttpExchange Methods
    @GetMapping("/user/{id}")
    public List<Product> getAllProductForUser(@PathVariable("id") Integer id) {
        return productService.getAllProductForUser(id);
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<?> addProductForUser(@PathVariable("id") Integer id, @RequestBody ProductRequest request) {
        return productService.addProductForUser(id, request);
    }
}
