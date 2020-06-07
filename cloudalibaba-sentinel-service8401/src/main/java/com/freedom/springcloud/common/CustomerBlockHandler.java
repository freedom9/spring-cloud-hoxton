package com.freedom.springcloud.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author freedom
 * @date 2020/5/21 20:55
 */
public class CustomerBlockHandler {

    public static CommonResult handleExceptionOne(BlockException exception) {
        return new CommonResult(444, "自定义全局异常-----1");
    }

    public static CommonResult handleExceptionTwo(BlockException exception) {
        return new CommonResult(444, "自定义全局异常-----2");
    }
}
