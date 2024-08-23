package io.spring.productsalesapi.usecase;

import io.spring.productsalesapi.domain.coupon.Coupon;
import io.spring.productsalesapi.domain.coupon.CouponType;
import io.spring.productsalesapi.repository.CouponRepository;
import io.spring.productsalesapi.service.coupon.CouponCreateCommand;
import io.spring.productsalesapi.service.coupon.CouponFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CouponCreateUseCase {
    private final Map<CouponType, CouponFactory> couponFactoryMap;
    private final CouponRepository couponRepository;

    public CouponCreateUseCase(List<CouponFactory> couponFactories, CouponRepository couponRepository) {
        this.couponFactoryMap = couponFactories.stream()
            .collect(Collectors.toMap(CouponFactory::getType, Function.identity()));
        this.couponRepository = couponRepository;
    }


    @Transactional
    public Long create(CouponCreateCommand command) {
        Coupon coupon = Optional.ofNullable(couponFactoryMap.get(command.couponType()))
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 쿠폰 생성 팩토리"))
            .create(command);

        return couponRepository.save(coupon).getId();
    }
}
