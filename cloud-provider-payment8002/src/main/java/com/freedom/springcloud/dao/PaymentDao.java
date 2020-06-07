package com.freedom.springcloud.dao;

import com.freedom.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baijianliang
 * @date 2020/4/13 20:46
 * @description
 */
@Mapper
public interface PaymentDao {

    public Payment getPaymentById(@Param("id") Long id);

    public int insert(Payment payment);
}
