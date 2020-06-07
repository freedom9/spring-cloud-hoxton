package com.freedom.springcloud.service;

/**
 * @author freedom
 * @date 2020/5/3 18:35
 */
public interface PaymentService {

     String paymentInfoOk();

     String paymentInfoTimeout();

     String paymentCircuitBreaker(Integer id);
}
