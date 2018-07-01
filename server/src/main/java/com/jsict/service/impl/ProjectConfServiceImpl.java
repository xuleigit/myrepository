package com.jsict.service.impl;

import com.jsict.entity.smoke.ProjectConf;
import com.jsict.repository.ProjectConfRepository;
import com.jsict.service.ProjectConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class ProjectConfServiceImpl implements ProjectConfService {

    @Autowired
    ProjectConfRepository projectConfRepository;

    @Override
    public ProjectConf saveOrUpdate(ProjectConf projectConf) {
        return projectConfRepository.save(projectConf);
    }

    @Override
    public ProjectConf findProjectConfByProjectIdAndEventId(Integer projectId, Integer eventId) {
        return projectConfRepository.findByProjectIdAndEventId(projectId,eventId);
    }
}
