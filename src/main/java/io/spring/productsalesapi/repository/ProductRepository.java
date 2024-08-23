package io.spring.productsalesapi.repository;

import io.spring.productsalesapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
