package com.cleanup.todoc.database.DAO;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author khalid
 */
@Dao
public interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createTask(Task task);


    @Query("SELECT * FROM Task WHERE projectId = :projectId")
    LiveData<List<Task>> getTasks(long projectId);
    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAllTasks();

    // @Query("SELECT * FROM Task WHERE projectId = :projectId")
    // Cursor getTasksWithCursor(long projectId);

    @Insert
//    long insertTask(Task task);
    public void insertTask(Task task);

    @Update
    public void updateTask(Task task);

    @Query("DELETE FROM Task WHERE id = :taskId")
    public void deleteTask(long taskId);

}