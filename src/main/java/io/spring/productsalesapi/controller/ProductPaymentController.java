package io.spring.productsalesapi.controller;

import io.spring.productsalesapi.service.ProductPaymentReceipt;
import io.spring.productsalesapi.service.ProductPaymentReceiptIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/product-payments")
@RestController
public class ProductPaymentController {

    private final ProductPaymentReceiptIssuer productPaymentReceiptIssuer;

    @GetMapping("/receipt")
    public ResponseEntity<ProductPaymentReceipt> findProductPaymentReceipt(Long productId, Long couponId) {

        ProductPaymentReceipt receipt = productPaymentReceiptIssuer.issue(productId, couponId);

        return ResponseEntity.ok(receipt);
    }
}
