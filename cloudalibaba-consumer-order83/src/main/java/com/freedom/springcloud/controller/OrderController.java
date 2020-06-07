package com.freedom.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author freedom
 * @date 2020/5/12 21:36
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-payment-service}")
    private String serverUrl;

    @GetMapping("/nacos")
    public String getPaymentInfo() {
        return restTemplate.getForObject(serverUrl + "/payment/nacos", String.class);
    }
}
