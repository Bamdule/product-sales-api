package io.spring.productsalesapi.service.coupon;

import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.CouponType;
import io.spring.productsalesapi.domain.coupon.PercentDiscountCoupon;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PercentDiscountCouponFactory implements CouponFactory {

    @Override
    public Coupon create(CouponCreateCommand command) {
        return PercentDiscountCoupon.create(command.couponName(), command.percentDiscountAmount());
    }

    @Override
    public CouponType getType() {
        return CouponType.PERCENT_DISCOUNT;
    }
}
