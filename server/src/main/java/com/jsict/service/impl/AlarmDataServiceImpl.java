package com.jsict.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jsict.entity.smoke.AlarmData;
import com.jsict.repository.AlarmDataRepository;
import com.jsict.repository.formybatis.AlarmDataRepositoryForMyBatis;
import com.jsict.service.AlarmDataService;
import com.jsict.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class AlarmDataServiceImpl implements AlarmDataService {

    @Autowired
    AlarmDataRepository alarmDataRepository;

    @Autowired
    AlarmDataRepositoryForMyBatis alarmDataRepositoryForMyBatis;

    @Override
    public AlarmData saveOrUpdate(AlarmData alarmData) {
        return alarmDataRepository.save(alarmData);
    }

    @Override
    public Date getAlarmDataLastOccursTime(Integer deviceId, Integer eventId) {
        List<AlarmData> list = alarmDataRepositoryForMyBatis.getAlarmDataLastOccursTime(deviceId,eventId);
        return list.size()>0?list.get(0).getOccursTime(): DateUtil.getDate("20180101 000000", "yyyyMMdd HHmmss");
    }

    @Override
    public List<AlarmData> getUnReleaseAlarmDataByDeviceId(Integer deviceId) {
        return alarmDataRepositoryForMyBatis.getUnReleaseAlarmDataByDeviceId(deviceId);
    }

    @Override
    public JSONObject findAlarmDataByAlarmIdFromView(Integer alarmId) {
        return alarmDataRepositoryForMyBatis.findAlarmDataByAlarmIdFromView(alarmId);
    }

    @Override
    public JSONObject findAlarmDataByAlarmEventIdAndEventId(String alarmEventId, Integer eventId) {
        return alarmDataRepositoryForMyBatis.findByAlarmEventIdAndEventId(alarmEventId,eventId);
    }
}
