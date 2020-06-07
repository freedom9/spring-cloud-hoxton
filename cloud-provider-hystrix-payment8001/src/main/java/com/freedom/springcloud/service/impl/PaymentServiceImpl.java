package com.freedom.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.freedom.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author freedom
 * @date 2020/5/3 18:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk() {
        return "线程池：" + Thread.currentThread().getName() + " payment_ok";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " payment_timeout";
    }

    public String paymentInfoTimeoutHandler() {
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙或运行报错，请稍后再试！！！";
    }


    // =========================服务熔断=========================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率到达多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }

        return Thread.currentThread().getName() + "\t调用成功，流水号：" + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id不能为负数，请输入正确的id再试, id = " + id;
    }
}
