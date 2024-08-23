package io.spring.productsalesapi.controller;

import io.spring.productsalesapi.controller.dto.CouponResponseDto;
import io.spring.productsalesapi.controller.dto.CouponSaveRequestDto;
import io.spring.productsalesapi.service.coupon.CouponFindService;
import io.spring.productsalesapi.usecase.CouponCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/coupons")
@RestController
public class CouponController {

    private final CouponCreateUseCase couponCreateUseCase;
    private final CouponFindService couponFindService;

    @PostMapping
    public ResponseEntity<Long> saveCoupon(@RequestBody CouponSaveRequestDto request) {
        Long id = couponCreateUseCase.create(request.toCommand());
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<CouponResponseDto>> findCoupons() {
        List<CouponResponseDto> responses = couponFindService.findAll()
            .stream()
            .map(CouponResponseDto::of)
            .toList();

        return ResponseEntity.ok(responses);
    }

}
