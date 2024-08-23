package io.spring.productsalesapi.service;

import io.spring.productsalesapi.domain.Product;
import io.spring.productsalesapi.domain.common.Money;
import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.FixedDiscountCoupon;
import io.spring.productsalesapi.domain.coupon.PercentDiscountCoupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPaymentReceiptCreatorTest {


    @Test
    public void 상품_고정할인쿠폰_적용() {

        ProductPaymentReceiptCreator productPaymentReceiptCreator = new ProductPaymentReceiptCreator();
        Product product = new Product(null, "포카칩", Money.of(1500));
        Coupon coupon = FixedDiscountCoupon.create("고정 할인 쿠폰", Money.of(500));

        ProductPaymentReceipt receipt = productPaymentReceiptCreator.create(product, coupon);

        Assertions.assertThat(receipt.totalPaymentAmount()).isEqualTo(Money.of(1000));
    }

    @Test
    public void 상품_퍼센트할인쿠폰_적용() {

        ProductPaymentReceiptCreator productPaymentReceiptCreator = new ProductPaymentReceiptCreator();
        Product product = new Product(null, "포카칩", Money.of(1500));
        Coupon coupon = PercentDiscountCoupon.create("퍼센트 할인 쿠폰", 0.1);

        ProductPaymentReceipt receipt = productPaymentReceiptCreator.create(product, coupon);

        Assertions.assertThat(receipt.totalPaymentAmount()).isEqualTo(Money.of(1350));
    }

}