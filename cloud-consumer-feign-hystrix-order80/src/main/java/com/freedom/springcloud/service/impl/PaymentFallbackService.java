package com.freedom.springcloud.service.impl;

import com.freedom.springcloud.service.PaymentService;
import org.springframework.context.annotation.Configuration;

/**
 * @author freedom
 * @date 2020/5/3 19:34
 */
@Configuration
public class PaymentFallbackService implements PaymentService {

    @Override
    public String paymentInfoOk() {
        return "paymentInfoOk fallback！！！";
    }

    @Override
    public String paymentInfoTimeout() {
        return "paymentInfoTimeout fallback！！！";
    }
}
