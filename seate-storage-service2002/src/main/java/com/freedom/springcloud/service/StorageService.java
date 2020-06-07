package com.freedom.springcloud.service;

/**
 * @author freedom
 * @date 2020/6/1 20:49
 */
public interface StorageService {

    void decrease(Long productId, Integer count);
}
