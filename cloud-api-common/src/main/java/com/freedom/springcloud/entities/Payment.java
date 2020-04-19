package com.freedom.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @author baijianliang
 * @date 2020/4/13 20:42
 * @description
 */
@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 7052260488566402631L;

    private Long id;

    private String serial;
}
