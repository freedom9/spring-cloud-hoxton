package com.freedom.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author freedom
 * @date 2020/5/4 21:09
 * @deprecation gateway网关配置
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // 事实证明，path是拼接在域名后面的，而不是直接访问uri路径的
        routes.route("baiduNew_route",
                r -> r.path("/guonei").uri("http://news.baidu.com"));
        routes.route("test", r -> r.path("/test")
                .filters(f -> f.rewritePath("/test", "/guonei")).uri("http://news.baidu.com");
        
        return routes.build();
    }
}
