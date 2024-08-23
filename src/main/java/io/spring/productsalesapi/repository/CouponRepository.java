package io.spring.productsalesapi.repository;

import io.spring.productsalesapi.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
