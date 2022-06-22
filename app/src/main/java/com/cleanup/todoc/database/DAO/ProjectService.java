package com.cleanup.todoc.database.DAO;

import com.cleanup.todoc.model.Project;

import java.util.List;

/**
 * @author khalid
 */
public interface ProjectService {

    /**
     * Get Project
     * @return {@link List}
     */
    public List<Project> getProjects();



}
