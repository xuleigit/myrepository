package com.jsict.service;

import com.alibaba.fastjson.JSONObject;
import com.jsict.entity.smoke.Devices;

import java.util.List;

/**
 * Created by zjy on 2018/6/11.
 */
public interface DevicesService {

    public Devices saveOrUpdate(Devices devices);

    public Devices findDevicesByIotDeviceId(String iotDeviceId);

    List<JSONObject> findDiviceTelesByDiviceId(String diviceIds);

    public Devices findByAid(String aid);

}
