package com.jsict.service.impl;

import com.jsict.entity.smoke.Sysconfig;
import com.jsict.repository.SysconfigRepository;
import com.jsict.service.SysconfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class SysconfServiceImpl implements SysconfService {

    @Autowired
    SysconfigRepository sysconfigRepository;

    @Override
    public Sysconfig saveOrUpdate(Sysconfig sysconf) {
        return sysconfigRepository.save(sysconf);
    }

    @Override
    public Sysconfig findSysconfByUnitIdAndEventId(Integer unitId, Integer eventId) {
        return sysconfigRepository.findByUnitIdAndEventId(unitId,eventId);
    }
}
