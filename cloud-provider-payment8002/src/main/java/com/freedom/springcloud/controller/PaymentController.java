package com.freedom.springcloud.controller;

import com.freedom.springcloud.common.CommonResult;
import com.freedom.springcloud.entities.Payment;
import com.freedom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author baijianliang
 * @date 2020/4/13 21:04
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("query result: {}", payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort = " + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录， 查询结果ID: " + id + ", serverPort = " + port);
        }
    }

    @PostMapping
    public CommonResult insert(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);

        if (result == 1) {
            return new CommonResult(200, "插入成功, serverPort = " + port, payment);
        } else {
            return new CommonResult(444, "插入失败, serverPort = " + port);
        }
    }

    @GetMapping("/timeout")
    public String OpenFeignTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
