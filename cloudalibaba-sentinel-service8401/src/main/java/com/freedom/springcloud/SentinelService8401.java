package com.freedom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author freedom
 * @date 2020/5/16 23:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401.class, args);
    }
}
