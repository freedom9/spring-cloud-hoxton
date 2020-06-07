package com.freedom.springcloud.controller;

import com.freedom.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author freedom
 * @date 2020/5/2 21:56
 */
@RestController
@RequestMapping(value = "/order")
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ok")
    // 没有指定fallback，使用全局fallback方法
//    @HystrixCommand
    public String paymentInfoOk() {
//        int i = 10 / 0;
        return paymentService.paymentInfoOk();
    }

    @GetMapping("/timeout")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000")
//    })
    public String paymentInfoTimeout() {
        return paymentService.paymentInfoTimeout();
    }

    public String paymentTimeoutFallbackMethod() {
        return "系统出错，请检测自身系统或者稍后再调用!!!";
    }

    /**
     * 全局fallback
     */
    public String paymentGlobalFallbackMethod() {
        return "全局异常处理信息，请稍后再试！！！";
    }
}
