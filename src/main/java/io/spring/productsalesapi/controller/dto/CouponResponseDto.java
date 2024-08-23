package io.spring.productsalesapi.controller.dto;

import io.spring.productsalesapi.domain.coupon.CouponInfo;
import io.spring.productsalesapi.domain.coupon.CouponType;

public record CouponResponseDto(Long id, CouponType couponType, Double discountPercent, Double discountAmount) {

    public static CouponResponseDto of(CouponInfo couponInfo) {
        return new CouponResponseDto(couponInfo.id(), couponInfo.couponType(), couponInfo.discountPercent(), couponInfo.discountAmount());
    }
}
