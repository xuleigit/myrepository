package com.jsict.service;


import com.jsict.entity.smoke.Sysconfig;

/**
 * Created by zjy on 2018/6/11.
 */
public interface SysconfService {

    public Sysconfig saveOrUpdate(Sysconfig sysconf);

    public Sysconfig findSysconfByUnitIdAndEventId(Integer unitId,Integer eventId);


}
