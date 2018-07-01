package com.jsict.service.impl;

import com.jsict.entity.smoke.Projects;
import com.jsict.repository.ProjectsRepository;
import com.jsict.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zjy on 2018/6/13.
 */
@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    ProjectsRepository projectsRepository;

    @Override
    public Projects saveOrUpdate(Projects projects) {
        return projectsRepository.save(projects);
    }

    @Override
    public Projects findProjectByProjectId(Integer projectId) {
        return projectsRepository.findByProjectId(projectId);
    }


}
