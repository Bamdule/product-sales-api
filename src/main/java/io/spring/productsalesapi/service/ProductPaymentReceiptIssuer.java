package io.spring.productsalesapi.service;

import io.spring.productsalesapi.domain.Product;
import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.repository.CouponRepository;
import io.spring.productsalesapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ProductPaymentReceiptIssuer {

    private final ProductPaymentReceiptCreator productPaymentReceiptCreator;
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;


    @Transactional(readOnly = true)
    public ProductPaymentReceipt issue(Long productId, Long couponId) {
        Product product = productRepository.findById(productId)
            .orElseThrow(IllegalArgumentException::new);

        Coupon coupon = couponRepository.findById(couponId)
            .orElseThrow(IllegalArgumentException::new);

        return productPaymentReceiptCreator.create(product, coupon);
    }

}
