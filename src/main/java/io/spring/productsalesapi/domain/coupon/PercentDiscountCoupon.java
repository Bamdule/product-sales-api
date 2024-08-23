package io.spring.productsalesapi.domain.coupon;

import io.spring.productsalesapi.domain.common.Money;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@DiscriminatorValue("PERCENT_DISCOUNT")
public class PercentDiscountCoupon extends Coupon {


    @Column(name = "discount_percent")
    private double discountPercent;

    private PercentDiscountCoupon(String name, double discountPercent) {
        super(name, CouponType.PERCENT_DISCOUNT);
        this.discountPercent = discountPercent;
    }

    public static PercentDiscountCoupon create(String name, double discountPercent) {
        return new PercentDiscountCoupon(name, discountPercent);
    }

    @Override
    public Money use(Money price) {
        return price.minus(price.calculatePercent(discountPercent));
    }

    @Override
    public CouponInfo toCouponInfo() {
        return new CouponInfo(this.getId(), this.getName(), this.getType(), this.discountPercent, null);
    }
}
