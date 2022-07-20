package com.cleanup.todoc.repository;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.DAO.ProjectDAO;
import com.cleanup.todoc.database.DAO.TaskDAO;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;


import java.util.Arrays;
import java.util.List;

/**
 * @author khalid
 */
public class TodocRepository {

    private final ProjectDAO projectDAO;
    private final TaskDAO taskDAO;


//  ??????????????????????????????

//     /**
//     * Get an instance on @{@link ProjectDAO  TaskDAO}
//     * @return
//     */
    public TodocRepository(ProjectDAO projectDAO, TaskDAO taskDAO) {
        this.projectDAO = projectDAO;
        this.taskDAO = taskDAO;
    }


//  ??????????????????????????????

    /**
     * Get always a new instance on @{@link ProjectDAO  TaskDAO}. Useful for tests, so we ensure the context is clean.
     * @return
     */

    // --- GET PROJECT ---
    //  Comment récupérer le projectId  ????????????????????
    public LiveData<Project> getProject(long projectId) { return this.projectDAO.getProject(projectId); }
    public LiveData<List<Project>> getProjects() { return this.projectDAO.getProjects(); }

    // --- GET TASK ---
    //  Comment récupérer le projectId  ????????????????????
    public LiveData<List<Task>> getTasks(long projectId) { return this.taskDAO.getTasks(projectId); }

    public LiveData<List<Task>> getAllTasks() {   return this.taskDAO.getAllTasks();   }


    //public List<Task> getTasks(long projectId) {
        //return (List<Task>) taskDAO.getTasks(projectId);
    //    return (List<Task>) taskDAO.getTasks(1);
    //}

    // --- CREATE ---
    public void createTask(Task task){ taskDAO.insertTask(task); }

    // --- DELETE ---
    public void deleteTask(long taskId) { taskDAO.deleteTask(taskId); }

    // --- UPDATE ---
    public void updateTask(Task task){ taskDAO.updateTask(task); }


    // --- ADD ---
    public void addTask(Task task){ taskDAO.insertTask(task); }







    //    public List <Meeting> getMeetings() {
//        List<Meeting> meetingList = service.getMeetings();
//        return meetingList;
//    }
//
//    public List <Meeting> getAllMeetings() {
//        List<Meeting> allMeetingList = service.getAllMeetings();
//        return allMeetingList;
//    }
//
//    public void meetingsNoFilter(){
//        filterOption = "noFilter";
//        service.meetingsNoFilter();
//    }
//
//    public void meetingsPlaceFilter(String place) {
//        filterOption = place;
//        service.meetingsPlaceFilter(place);
//    }
//
//    public void meetingsDateFilter(String date) {
//        filterOption = date;
//        service.meetingsDateFilter(date);
//    }
//
//    public void deleteMeeting(Meeting meeting) {
//        service.deleteMeeting(meeting);
//    }
//
//    public Meeting createMeeting(Meeting meeting) {
//        boolean isCurrentlyFiltered = meeting.getPlace().equalsIgnoreCase(filterOption);
//       return service.createMeeting(meeting, isCurrentlyFiltered);
//    }
}
