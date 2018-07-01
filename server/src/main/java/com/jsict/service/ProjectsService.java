package com.jsict.service;

import com.jsict.entity.smoke.Projects;

/**
 * Created by zjy on 2018/6/11.
 */
public interface ProjectsService {

    public Projects saveOrUpdate(Projects projects);

    public Projects findProjectByProjectId(Integer projectId);


}
