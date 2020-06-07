package com.freedom.springcloud.dao;

import com.freedom.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author freedom
 * @date 2020/5/30 22:06
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    void updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
