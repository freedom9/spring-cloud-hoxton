package com.freedom.springcloud.service.impl;

import com.freedom.springcloud.dao.PaymentDao;
import com.freedom.springcloud.entities.Payment;
import com.freedom.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author baijianliang
 * @date 2020/4/13 20:58
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }
}
