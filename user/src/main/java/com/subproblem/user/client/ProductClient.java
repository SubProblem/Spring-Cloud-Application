package com.subproblem.user.client;

import com.subproblem.user.dto.Product;
import com.subproblem.user.dto.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface ProductClient {

    @GetExchange("/api/v1/product/user/{id}")
    public List<Product> getAllProductForUser(@PathVariable("id") Integer id);

    @PostExchange("/api/v1/product/user/{id}")
    public ResponseEntity<?> addProductForUser(@PathVariable("id") Integer id, @RequestBody ProductRequest request);

}
