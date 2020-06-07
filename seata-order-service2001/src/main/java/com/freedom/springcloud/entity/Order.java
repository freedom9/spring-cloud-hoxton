package com.freedom.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author freedom
 * @date 2020/5/30 22:02
 */
@Data
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 1042365394061930832L;

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态： 0：创建中   1：已完结
     */
    private Integer status;
}
