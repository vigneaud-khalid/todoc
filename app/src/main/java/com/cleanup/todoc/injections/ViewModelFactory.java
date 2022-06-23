package com.cleanup.todoc.injections;

import android.content.Context;
import android.text.style.TabStopSpan;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cleanup.todoc.database.DAO.TodocDatabase;
import com.cleanup.todoc.repository.TodocRepository;
import com.cleanup.todoc.viewmodel.TaskViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author khalid
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final TodocRepository todocRepository;

    private final Executor executor;

    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance(Context context) {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory(context);
                }
            }
        }
        return factory;
    }

    private ViewModelFactory(Context context) {
        TodocDatabase todocDatabase = TodocDatabase.getInstance(context);
        this.todocRepository = new TodocRepository(todocDatabase.projectDao(),todocDatabase.taskDao());
        this.executor = Executors.newSingleThreadExecutor();
    }

    @Override
    @NotNull
    public <T extends ViewModel>  T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TaskViewModel.class)) {
            return (T) new TaskViewModel(todocRepository, executor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}