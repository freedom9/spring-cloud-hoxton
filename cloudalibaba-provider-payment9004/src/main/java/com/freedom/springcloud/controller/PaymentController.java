package com.freedom.springcloud.controller;

import com.freedom.springcloud.common.CommonResult;
import com.freedom.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author freedom
 * @date 2020/5/24 21:02
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "123dasf2r"));
        hashMap.put(2L, new Payment(2L, "123dasfq3"));
        hashMap.put(3L, new Payment(3L, "123dasfas"));
    }

    @GetMapping("/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult(200, "serverPort: " + serverPort, payment);
    }
}
