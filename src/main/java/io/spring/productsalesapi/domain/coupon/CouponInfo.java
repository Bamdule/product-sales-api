package io.spring.productsalesapi.domain.coupon;

public record CouponInfo(Long id, String name, CouponType couponType, Double discountPercent, Double discountAmount) {
}
