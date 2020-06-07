package com.freedom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author freedom
 * @date 2020/5/12 21:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain9002.class, args);
    }
}
