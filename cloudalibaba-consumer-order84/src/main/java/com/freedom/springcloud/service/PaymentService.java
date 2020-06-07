package com.freedom.springcloud.service;

import com.freedom.springcloud.common.CommonResult;
import com.freedom.springcloud.service.ipml.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author freedom
 * @date 2020/5/24 22:21
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);
}
