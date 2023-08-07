package com.subproblem.product;

import com.subproblem.product.entity.Product;
import com.subproblem.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {

			var product = Product.builder()
					.id(1)
					.userId(1)
					.name("product1")
					.description("description1")
					.price(BigDecimal.valueOf(100))
					.build();

			productRepository.save(product);
		};
	}
}
