package com.cleanup.todoc.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.di.DI;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.TodocRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author khalid
 */
public class TaskViewModel extends ViewModel {

    Context context;
// initialisation via la DI
    private TodocRepository todocRepository;
    private final Executor executor;
    private LiveData<List<Project>> projectsLiveData;
    private LiveData<List<Task>> tasksLiveData;

    public TaskViewModel(TodocRepository todocRepository, Executor executor) {
        this.todocRepository = todocRepository;
        this.executor = executor;
        projectsLiveData = todocRepository.getProjects();
        tasksLiveData = todocRepository.getAllTasks();

    }

    public LiveData<List<Project>> getProjectsLiveData() { return projectsLiveData;  }

    public LiveData<List<Task>> getTasksLiveData() {
        return tasksLiveData;
    }

    // FOR TASK IN A PROJECT
    public LiveData<List<Task>> getTasksAProject(long projectId) { return todocRepository.getTasks(projectId); }

    // FOR All TASKs
    public LiveData<List<Task>> getAllTasks() { return todocRepository.getAllTasks(); }

    public void createTask(long id, long projectId, String name, long creationTimestamp) {
        executor.execute(() -> todocRepository.createTask(new Task(id, projectId, name, creationTimestamp))); }

    public void deleteTask(long taskId) { executor.execute(() -> todocRepository.deleteTask(taskId)); }

    public void updateTask(Task task) { executor.execute(() -> todocRepository.updateTask(task)); }

    public void addTask(Task task) { executor.execute(() -> todocRepository.addTask(task)); }

}