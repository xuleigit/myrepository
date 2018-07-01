package com.jsict.service.impl;

import com.jsict.entity.smoke.LockRecord;
import com.jsict.repository.LockRecordRepository;
import com.jsict.service.LockRecordService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: XL
 * @Date: Created in 2018/6/29
 * @Description:
 */
public class LockRecordServiceImpl implements LockRecordService{

    @Autowired
    LockRecordRepository lockRecordRepository;

    @Override
    public LockRecord saveOrUpdate(LockRecord lockRecord) {
        return lockRecordRepository.save(lockRecord);
    }
}
