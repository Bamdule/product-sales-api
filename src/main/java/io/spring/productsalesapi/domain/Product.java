package io.spring.productsalesapi.domain;

import io.spring.productsalesapi.domain.common.Money;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    @AttributeOverride(name = "amount", column = @Column(name = "price", nullable = false))
    @Embedded
    private Money price;
}
