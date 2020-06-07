package com.freedom.springcloud.service;

import com.freedom.springcloud.entities.Payment;

/**
 * @author baijianliang
 * @date 2020/4/13 20:59
 * @description
 */
public interface PaymentService {

    Payment getPaymentById(Long id);

    int insert(Payment payment);
}
