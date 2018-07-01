package com.jsict.service.impl;

import com.jsict.entity.smoke.PlatformConf;
import com.jsict.repository.PlatformConfRepository;
import com.jsict.service.PlatformConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class PlatformConfigServiceImpl implements PlatformConfigService {

    @Autowired
    PlatformConfRepository platformConfRepository;

    @Override
    public PlatformConf saveOrUpdate(PlatformConf platformConf) {
        return platformConfRepository.save(platformConf);
    }

    @Override
    public PlatformConf findPlatformConfigByDeviceModelName(String deviceModelName) {
        return platformConfRepository.findByDeviceModelName(deviceModelName);
    }
}
