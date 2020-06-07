package com.freedom.springcloud.service;

import java.math.BigDecimal;

/**
 * @author freedom
 * @date 2020/6/1 21:12
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
