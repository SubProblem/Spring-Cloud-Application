package com.subproblem.product.service;

import com.subproblem.product.client.UserClient;
import com.subproblem.product.dto.ProductRequest;
import com.subproblem.product.dto.ProductResponse;
import com.subproblem.product.entity.Product;
import com.subproblem.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserClient userClient;

    public List<ProductResponse> getAllProducts() {
        var products = productRepository.findAll();

        return products.stream()
                .map(this::convertToProductDto)
                .toList();
    }

    public ResponseEntity<?> addProduct(ProductRequest request) {

        var product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();

        productRepository.save(product);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<Product> getAllProductForUser(Integer id) {
        var products = productRepository.findAllByUserId(id);

        return products;
//        return products.stream()
//                .map(this::convertToProductDto)
//                .toList();
    }

    private ProductResponse convertToProductDto(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public ResponseEntity<?> addProductForUser(Integer id, ProductRequest request) {

        var product = Product.builder()
                .userId(id)
                .description(request.description())
                .name(request.name())
                .price(request.price())
                .build();

        productRepository.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
