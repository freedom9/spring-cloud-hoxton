package com.freedom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.freedom.springcloud.common.CommonResult;
import com.freedom.springcloud.entities.Payment;
import com.freedom.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author freedom
 * @date 2020/5/24 21:26
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/fallback/{id}")
    // 没有配置
//     @SentinelResource(value = "fallback")
    // fallback只负责业务异常
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    // blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(serverUrl + "/payment/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常！！！");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常！！！");
        }

        return result;
    }

    public CommonResult handlerFallback(Long id, Throwable e) {
        return new CommonResult(444,
                "兜底异常handlerFallback, 异常内容：" + e.getMessage(), new Payment(id, null));
    }

    public CommonResult blockHandler(Long id, BlockException blockException) {
        return new CommonResult(445,
                "blockHandler-sentinel限流，blockException: " + blockException.getMessage(),
                new Payment(id, null));
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

}
