package com.jsict.service.impl;

import com.jsict.entity.smoke.DevicesInfo;
import com.jsict.repository.DevicesInfoRepository;
import com.jsict.service.DevicesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class DevicesInfoServiceImpl implements DevicesInfoService {

    @Autowired
    DevicesInfoRepository devicesInfoRepository;


    @Override
    public DevicesInfo saveOrUpdate(DevicesInfo devicesInfo) {
        return devicesInfoRepository.save(devicesInfo);
    }

    @Override
    public DevicesInfo findDevicesInfoByAid(String aid) {
        return devicesInfoRepository.findByAid(aid);
    }

    @Override
    public DevicesInfo findByIotDeviceId(String iotDeviceId) {
        return devicesInfoRepository.findByIotDeviceId(iotDeviceId);
    }
}
