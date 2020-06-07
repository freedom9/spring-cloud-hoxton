package com.freedom.springcloud.Controller;

import com.freedom.springcloud.common.CommonResult;
import com.freedom.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author freedom
 * @date 2020/5/2 20:48
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public String OpenFeignTimeout() {
        // OpenFeign默认等待1秒钟，超过后报错
        return paymentService.OpenFeignTimeout();
    }
}
