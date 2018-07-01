package com.jsict.service;


import com.jsict.entity.smoke.ProjectConf;

/**
 * Created by zjy on 2018/6/11.
 */
public interface ProjectConfService {

    public ProjectConf saveOrUpdate(ProjectConf projectConf);

    public ProjectConf findProjectConfByProjectIdAndEventId(Integer projectId,Integer eventId);


}
