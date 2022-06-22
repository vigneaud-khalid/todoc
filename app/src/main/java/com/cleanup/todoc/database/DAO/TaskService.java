package com.cleanup.todoc.database.DAO;

import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * @author khalid
 */
public interface TaskService {

    /**
     * Get Project
     * @return {@link List}
     */
    public List<Task> getTasks();



}
