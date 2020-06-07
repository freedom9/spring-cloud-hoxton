package com.freedom.springcloud.service;

import com.freedom.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author freedom
 * @date 2020/5/2 21:54
 */
@Configuration
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/hystrix/ok")
    public String paymentInfoOk();

    @GetMapping("/payment/hystrix/timeout")
    public String paymentInfoTimeout();
}
