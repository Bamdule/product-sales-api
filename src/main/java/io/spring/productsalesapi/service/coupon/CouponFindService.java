package io.spring.productsalesapi.service.coupon;

import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.CouponInfo;
import io.spring.productsalesapi.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CouponFindService {

    private final CouponRepository couponRepository;

    @Transactional(readOnly = true)
    public List<CouponInfo> findAll() {
        return couponRepository.findAll()
            .stream()
            .map(Coupon::toCouponInfo)
            .toList();
    }
}
