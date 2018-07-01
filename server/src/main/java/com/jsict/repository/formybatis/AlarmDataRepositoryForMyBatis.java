package com.jsict.repository.formybatis;


import com.alibaba.fastjson.JSONObject;
import com.jsict.entity.smoke.AlarmData;

import java.util.List;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface AlarmDataRepositoryForMyBatis {

    List<AlarmData> getAlarmDataLastOccursTime(Integer deviceId,Integer eventId);

    List<AlarmData> getUnReleaseAlarmDataByDeviceId(Integer deviceId);

    JSONObject findByAlarmEventIdAndEventId(String alarmEventId,Integer eventId);

    JSONObject findAlarmDataByAlarmIdFromView(Integer alarmId);

}
