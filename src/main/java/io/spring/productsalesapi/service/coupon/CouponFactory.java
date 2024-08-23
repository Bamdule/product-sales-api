package io.spring.productsalesapi.service.coupon;

import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.CouponType;

public interface CouponFactory {
    Coupon create(CouponCreateCommand command);

    CouponType getType();
}
