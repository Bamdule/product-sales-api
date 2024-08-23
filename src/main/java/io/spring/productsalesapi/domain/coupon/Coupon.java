package io.spring.productsalesapi.domain.coupon;

import io.spring.productsalesapi.domain.common.Money;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "coupon_type")
public abstract class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "coupon_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private CouponType type;

    protected Coupon(String name, CouponType type) {
        this.name = name;
        this.type = type;
    }

    public abstract Money use(Money price);

    public abstract CouponInfo toCouponInfo();
}
