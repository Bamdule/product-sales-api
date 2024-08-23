package io.spring.productsalesapi.controller.dto;

import io.spring.productsalesapi.domain.coupon.CouponType;
import io.spring.productsalesapi.service.coupon.CouponCreateCommand;

public record CouponSaveRequestDto(
    CouponType couponType, String couponName, Double fixedDiscountAmount, Double percentDiscountAmount
) {

    public CouponCreateCommand toCommand() {
        return new CouponCreateCommand(couponType, couponName, fixedDiscountAmount, percentDiscountAmount);
    }
}
