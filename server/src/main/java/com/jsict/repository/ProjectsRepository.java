package com.jsict.repository;

import com.jsict.entity.smoke.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface ProjectsRepository extends JpaRepository<Projects, String> {
    Projects findByProjectId(Integer projectId);
}
