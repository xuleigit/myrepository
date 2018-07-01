package com.jsict.service;


import com.alibaba.fastjson.JSONObject;
import com.jsict.entity.smoke.AlarmData;

import java.util.Date;
import java.util.List;

/**
 * Created by zjy on 2018/6/11.
 */
public interface AlarmDataService {

    public AlarmData saveOrUpdate(AlarmData alarmData);

    public Date getAlarmDataLastOccursTime(Integer deviceId, Integer eventId);

    public List<AlarmData> getUnReleaseAlarmDataByDeviceId(Integer deviceId);

    public JSONObject findAlarmDataByAlarmIdFromView(Integer alarmId);

    public JSONObject findAlarmDataByAlarmEventIdAndEventId(String alarmEventId,Integer eventId);


}
