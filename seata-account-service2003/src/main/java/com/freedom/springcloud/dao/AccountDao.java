package com.freedom.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author freedom
 * @date 2020/6/1 21:07
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
