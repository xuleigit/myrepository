package com.jsict.repository;

import com.jsict.entity.smoke.ProjectConf;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface ProjectConfRepository extends JpaRepository<ProjectConf, String> {


    public ProjectConf findByProjectIdAndEventId(Integer projectId, Integer eventId);
}
