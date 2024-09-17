package com.yas.paymentpaypal.controller;

import com.yas.paymentpaypal.service.PaypalService;
import com.yas.paymentpaypal.viewmodel.CapturedPaymentVm;
import com.yas.paymentpaypal.viewmodel.PaypalRequestPayment;
import com.yas.paymentpaypal.viewmodel.RequestPayment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment-paypal")
public class PaypalController {
    private final PaypalService paypalService;

    @PostMapping(value = "/init")
    public PaypalRequestPayment createPayment(@Valid @RequestBody RequestPayment requestPayment) {
        return paypalService.createPayment(requestPayment);
    }

    @GetMapping(value = "/capture")
    public CapturedPaymentVm capturePayment(@RequestParam("token") String token) {
        return paypalService.capturePayment(token);
    }

    @GetMapping(value = "/cancel")
    public ResponseEntity<String> cancelPayment() {
        return ResponseEntity.ok("Payment cancelled");
    }
}