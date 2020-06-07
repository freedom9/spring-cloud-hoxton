package com.freedom.springcloud.service.impl;

import com.freedom.springcloud.dao.OrderDao;
import com.freedom.springcloud.entity.Order;
import com.freedom.springcloud.service.AccountService;
import com.freedom.springcloud.service.OrderService;
import com.freedom.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author freedom
 * @date 2020/5/30 22:16
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "freedom", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始新建订单");
        orderDao.create(order);

        log.info("订单微服务调用库存开始，扣除库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务调用库存结束，扣除库存");

        log.info("订单微服务调用账号开始，扣除金额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("订单微服务调用账号开始，扣除金额");

        log.info("修改订单状态开始");
        orderDao.updateStatus(order.getId(), 1);
    }
}
