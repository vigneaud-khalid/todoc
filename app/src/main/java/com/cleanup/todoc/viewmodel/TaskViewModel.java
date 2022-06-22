package com.cleanup.todoc.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.di.DI;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.TodocRepository;

import java.util.ArrayList;

/**
 * @author khalid
 */
public class TaskViewModel extends ViewModel {

    Context context;
// initialisation via la DI

    private TodocRepository todocRepository = DI.getTodocRepository(context);




    //    deleteTask(long taskId)
    public int deleteTask(long taskId) {
        return todocRepository.deleteTask(taskId);
    }


}
