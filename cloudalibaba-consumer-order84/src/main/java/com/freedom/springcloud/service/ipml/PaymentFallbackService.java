package com.freedom.springcloud.service.ipml;

import com.freedom.springcloud.common.CommonResult;
import com.freedom.springcloud.entities.Payment;
import com.freedom.springcloud.service.PaymentService;
import org.springframework.context.annotation.Configuration;

/**
 * @author freedom
 * @date 2020/5/24 22:22
 */
@Configuration
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult(444,
                "异常降级返回， paymentFallbackService", new Payment(id, null));
    }
}
