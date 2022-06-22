package com.cleanup.todoc.repository;

import com.cleanup.todoc.database.DAO.DAOProjectService;
import com.cleanup.todoc.database.DAO.ProjectDAO;
import com.cleanup.todoc.database.DAO.ProjectService;
import com.cleanup.todoc.database.DAO.TaskDAO;


/**
 * @author khalid
 */
public class TodocRepository {

    private final ProjectDAO projectDAO;
    private final TaskDAO taskDAO;

    public TodocRepository(ProjectDAO projectDAO, TaskDAO taskDAO) {
        this.projectDAO = projectDAO;
        this.taskDAO = taskDAO;
    }


//     /**
//     * Get an instance on @{@link MeetingApiService}
//     * @return
//     */

    /**
     * Get always a new instance on @{@link ProjectService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static ProjectService getNewInstanceService() {
        return new DAOProjectService();
    }

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
