package com.jsict.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jsict.entity.smoke.Devices;
import com.jsict.repository.DevicesRepository;
import com.jsict.repository.formybatis.DevicesRepositoryForMyBatis;
import com.jsict.service.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class DevicesServiceImpl implements DevicesService {

    @Autowired
    DevicesRepository devicesRepository;

    @Autowired
    DevicesRepositoryForMyBatis devicesRepositoryForMyBatis;

    @Override
    public Devices saveOrUpdate(Devices devices) {
        return devicesRepository.save(devices);
    }

    @Override
    public Devices findDevicesByIotDeviceId(String iotDeviceId) {

        List<Devices> list = devicesRepositoryForMyBatis.findDevicesByIotDeviceId(iotDeviceId);

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<JSONObject> findDiviceTelesByDiviceId(String diviceIds) {
        return devicesRepositoryForMyBatis.findDiviceTelesByDiviceId(diviceIds);
    }

    @Override
    public Devices findByAid(String aid) {
        return devicesRepository.findByAid(aid);
    }
}
