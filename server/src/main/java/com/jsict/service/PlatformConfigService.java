package com.jsict.service;

import com.jsict.entity.smoke.PlatformConf;

/**
 * Created by zjy on 2018/6/11.
 */
public interface PlatformConfigService {

    public PlatformConf saveOrUpdate(PlatformConf platformConf);

    public PlatformConf findPlatformConfigByDeviceModelName(String deviceModelName);
}
