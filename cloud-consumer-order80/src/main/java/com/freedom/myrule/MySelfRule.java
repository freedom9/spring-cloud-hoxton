package com.freedom.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author freedom
 * @date 2020/4/29 20:55
 * @deprecation 自定义负载均衡策略配置类不能放在@ComponentScan所扫描的当前包下一级子包下，
 *              否则配置类会被所有的Ribbon客户端所共享，达不到特殊化定制的目的。
 */
@Configuration
public class MySelfRule {

    /**
     * 负载均衡策略
     * 1、RoundRobinRule：轮询（默认）。
     * 2、RandomRule：随机。
     * 3、RetryRule：先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务。
     * 4、WeightedResponseTimeRule：对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选中。
     * 5、BestAvailableRule：会先过滤掉由于多次访问故障而处于短路器跳闸状态的服务，然后选择一个并发量最小的服务。
     * 6、AvailabilityFilteringRule：先过滤故障实例，再选择并发较小的实例。
     * 7、ZoneAvoidanceRule：复合判断server所在区域的性能和server的可用性选择服务器。
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
