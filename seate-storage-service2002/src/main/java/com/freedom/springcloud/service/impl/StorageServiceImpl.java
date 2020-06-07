package com.freedom.springcloud.service.impl;

import com.freedom.springcloud.dao.StorageDao;
import com.freedom.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author freedom
 * @date 2020/6/1 20:50
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
