package com.freedom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author freedom
 * @date 2020/5/10 18:02
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProvider8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProvider8801.class, args);
    }
}
