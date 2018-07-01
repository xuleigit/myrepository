package com.jsict.repository;

import com.jsict.entity.smoke.DevicesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface DevicesInfoRepository extends JpaRepository<DevicesInfo, String> {

    DevicesInfo findByAid(String aid);

    DevicesInfo findByIotDeviceId(String iotDeviceId);

}
