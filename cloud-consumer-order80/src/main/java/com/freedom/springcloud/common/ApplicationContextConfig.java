package com.freedom.springcloud.common;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author baijianliang
 * @date 2020/4/13 21:20
 * @description
 */
@RestController
public class ApplicationContextConfig {

    @Bean
    // 注释，使用自己手写的负载均衡的规则
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
