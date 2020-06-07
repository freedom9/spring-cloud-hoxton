package com.freedom.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author baijianliang
 * @date 2020/4/19 21:41
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String paymentZK() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
