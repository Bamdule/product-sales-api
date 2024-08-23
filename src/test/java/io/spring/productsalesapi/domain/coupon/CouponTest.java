package io.spring.productsalesapi.domain.coupon;

import io.spring.productsalesapi.domain.common.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CouponTest {
    @Test
    public void 고정할인_쿠폰_사용_테스트() {
        //given
        Coupon 고정_할인_쿠폰 = FixedDiscountCoupon.create("고정 할인 쿠폰", Money.of(1000));

        //when
        Money discountPrice = 고정_할인_쿠폰.use(Money.of(2000));

        //then
        Assertions.assertThat(discountPrice).isEqualTo(Money.of(1000));
    }

    @Test
    public void 퍼센트할인_쿠폰_사용_테스트() {
        //given
        Coupon 퍼센트_할인_쿠폰 = PercentDiscountCoupon.create("퍼센트_할인_쿠폰", 0.1);

        //when
        Money discountPrice = 퍼센트_할인_쿠폰.use(Money.of(2000));

        //then
        Assertions.assertThat(discountPrice).isEqualTo(Money.of(1800));
    }
}