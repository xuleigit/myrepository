package com.jsict.service;


import com.jsict.entity.smoke.DevicesInfo;

/**
 * Created by zjy on 2018/6/11.
 */
public interface DevicesInfoService {

    public DevicesInfo saveOrUpdate(DevicesInfo devicesInfo);

    public DevicesInfo findDevicesInfoByAid(String aid);

    public DevicesInfo findByIotDeviceId(String iotDeviceId);


}
