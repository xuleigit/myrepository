package com.jsict.service.impl;

import com.jsict.entity.smoke.AlarmNotifiRecord;
import com.jsict.repository.AlarmNotifiRecordRepository;
import com.jsict.service.AlarmNotifiRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class AlarmNotifiRecordServiceImpl implements AlarmNotifiRecordService {

    @Autowired
    AlarmNotifiRecordRepository alarmNotifiRecordRepository;

    @Override
    public List<AlarmNotifiRecord> addAlarmNotifiRecord(List<AlarmNotifiRecord> recodeList) {
        List<AlarmNotifiRecord> result = alarmNotifiRecordRepository.saveAll(recodeList);
        return result;
    }
}
