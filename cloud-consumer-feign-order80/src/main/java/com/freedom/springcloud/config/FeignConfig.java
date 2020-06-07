package com.freedom.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author freedom
 * @date 2020/5/2 21:18
 */
@Configuration
public class FeignConfig {

    /**
     * feign日志级别：
     * 1、NONE：默认的，不显示任何日志。
     * 2、BASIC：仅记录请求方法、URL、响应状态码及执行时间。
     * 3、HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头部信息。
     * 4、FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
