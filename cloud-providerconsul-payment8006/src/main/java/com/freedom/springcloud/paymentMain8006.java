package com.freedom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author freedom
 * @date 2020/4/25 20:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class paymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8006.class, args);
    }
}
