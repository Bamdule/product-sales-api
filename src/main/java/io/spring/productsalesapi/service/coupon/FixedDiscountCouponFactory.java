package io.spring.productsalesapi.service.coupon;

import io.spring.productsalesapi.domain.common.Money;
import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.CouponType;
import io.spring.productsalesapi.domain.coupon.FixedDiscountCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FixedDiscountCouponFactory implements CouponFactory {

    @Override
    public Coupon create(CouponCreateCommand command) {
        return FixedDiscountCoupon.create(command.couponName(), Money.of(command.fixedDiscountAmount()));
    }

    @Override
    public CouponType getType() {
        return CouponType.FIXED_DISCOUNT;
    }
}
