package io.spring.productsalesapi.domain.coupon;

import io.spring.productsalesapi.domain.common.Money;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@DiscriminatorValue("FIXED_DISCOUNT")
public class FixedDiscountCoupon extends Coupon {

    @AttributeOverride(name = "amount", column = @Column(name = "discount_amount"))
    @Embedded
    private Money discountAmount;

    private FixedDiscountCoupon(String name, Money discountAmount) {
        super(name, CouponType.FIXED_DISCOUNT);
        this.discountAmount = discountAmount;
    }

    public static FixedDiscountCoupon create(String name, Money discountAmount) {
        return new FixedDiscountCoupon(name, discountAmount);
    }

    @Override
    public Money use(Money price) {
        return price.minus(discountAmount);
    }

    @Override
    public CouponInfo toCouponInfo() {
        return new CouponInfo(this.getId(), this.getName(), this.getType(), null, discountAmount.amount());
    }
}
