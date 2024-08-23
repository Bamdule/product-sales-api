package io.spring.productsalesapi.repository;

import io.spring.productsalesapi.domain.common.Money;
import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.CouponType;
import io.spring.productsalesapi.domain.coupon.FixedDiscountCoupon;
import io.spring.productsalesapi.domain.coupon.PercentDiscountCoupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class CouponRepositoryTest {

    @Autowired
    public CouponRepository couponRepository;

    @Autowired
    public TestEntityManager testEntityManager;


    @Test
    public void 고정할인_쿠폰_저장() {
        Coupon coupon = couponRepository.save(FixedDiscountCoupon.create("고정 할인 쿠폰", Money.of(1000)));

        Assertions.assertThat(coupon.getId()).isNotNull();
        Assertions.assertThat(coupon.getType()).isEqualTo(CouponType.FIXED_DISCOUNT);
        Assertions.assertThat(((FixedDiscountCoupon) coupon).getDiscountAmount()).isEqualTo(Money.of(1000));
    }

    @Test
    public void 퍼센트할인_쿠폰_저장() {
        Coupon coupon = couponRepository.save(PercentDiscountCoupon.create("퍼센트 할인 쿠폰", 0.5));

        Assertions.assertThat(coupon.getId()).isNotNull();
        Assertions.assertThat(coupon.getType()).isEqualTo(CouponType.PERCENT_DISCOUNT);
        Assertions.assertThat(((PercentDiscountCoupon) coupon).getDiscountPercent()).isEqualTo(0.5);
    }

    @Test
    public void 고정할인_쿠폰_조회() {
        Coupon coupon = couponRepository.save(FixedDiscountCoupon.create("고정 할인 쿠폰", Money.of(1000)));
        testEntityManager.flush();
        testEntityManager.clear();

        Coupon findCoupon = couponRepository.findById(coupon.getId()).get();

        Assertions.assertThat(findCoupon.getId()).isNotNull();
        Assertions.assertThat(findCoupon.getType()).isEqualTo(CouponType.FIXED_DISCOUNT);
        Assertions.assertThat(((FixedDiscountCoupon) findCoupon).getDiscountAmount()).isEqualTo(Money.of(1000));
    }

    @Test
    public void 퍼센트할인_쿠폰_조회() {
        Coupon coupon = couponRepository.save(PercentDiscountCoupon.create("퍼센트 할인 쿠폰", 0.1));
        testEntityManager.flush();
        testEntityManager.clear();

        Coupon findCoupon = couponRepository.findById(coupon.getId()).get();

        Assertions.assertThat(findCoupon.getId()).isNotNull();
        Assertions.assertThat(findCoupon.getType()).isEqualTo(CouponType.PERCENT_DISCOUNT);
        Assertions.assertThat(((PercentDiscountCoupon) findCoupon).getDiscountPercent()).isEqualTo(0.1);
    }

    public void test() {

        Coupon coupon
        CouponType couponType = CouponType.FIXED_DISCOUNT;
        switch (couponType) {
            case FIXED_DISCOUNT :
                break;
            case PERCENT_DISCOUNT:
                break;
        }
    }

}