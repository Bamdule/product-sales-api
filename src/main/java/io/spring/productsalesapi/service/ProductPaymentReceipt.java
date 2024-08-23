package io.spring.productsalesapi.service;

import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.Product;
import io.spring.productsalesapi.domain.common.Money;

public record ProductPaymentReceipt(Product product, Coupon coupon, Money totalPaymentAmount) {
}
