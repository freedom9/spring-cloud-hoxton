package com.freedom.springcloud.controller;

import com.freedom.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author freedom
 * @date 2020/5/2 21:42
 */
@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ok")
    public String paymentInfoOk() {
        return paymentService.paymentInfoOk();
    }

    @GetMapping("/timeout")
    public String paymentInfoTimeout() {
       return paymentService.paymentInfoTimeout();
    }

    @GetMapping("/circuitbreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
