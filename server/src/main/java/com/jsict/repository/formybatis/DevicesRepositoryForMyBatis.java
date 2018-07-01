package com.jsict.repository.formybatis;


import com.alibaba.fastjson.JSONObject;
import com.jsict.entity.smoke.Devices;

import java.util.List;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface DevicesRepositoryForMyBatis {

    List<Devices> findDevicesByIotDeviceId(String iotDeviceId);

    List<JSONObject> findDiviceTelesByDiviceId(String diviceIds);

}
