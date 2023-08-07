package com.subproblem.product.repository;

import com.subproblem.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByUserId(Integer id);
}
