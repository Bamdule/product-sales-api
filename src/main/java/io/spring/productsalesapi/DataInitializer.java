package io.spring.productsalesapi;

import io.spring.productsalesapi.domain.Product;
import io.spring.productsalesapi.domain.common.Money;
import io.spring.productsalesapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationRunner {
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        productRepository.save(new Product(null, "포카칩", Money.of(1500)));
    }
}