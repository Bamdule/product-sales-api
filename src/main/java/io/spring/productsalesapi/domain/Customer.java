package io.spring.productsalesapi.domain;

import io.spring.productsalesapi.domain.common.Money;
import jakarta.persistence.*;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @AttributeOverride(name = "amount", column = @Column(name = "points"))
    @Embedded
    private Money points;


}
