package io.spring.productsalesapi.service;

import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductPaymentReceiptCreator {

    public ProductPaymentReceipt create(Product product, Coupon coupon) {
        return new ProductPaymentReceipt(product, coupon, coupon.use(product.getPrice()));
    }
}
