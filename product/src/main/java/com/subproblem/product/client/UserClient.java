package com.subproblem.product.client;

import com.subproblem.product.dto.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface UserClient {

    @PostExchange("/{userId}/product")
    ResponseEntity<?> addProduct(@PathVariable("userId") Integer userId, @RequestBody ProductRequest request);
}
