package io.spring.productsalesapi.service.coupon;

import io.spring.productsalesapi.domain.coupon.CouponType;

public record CouponCreateCommand(CouponType couponType, String couponName, Double fixedDiscountAmount,
                                  Double percentDiscountAmount) {
}
