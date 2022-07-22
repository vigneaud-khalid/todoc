package com.cleanup.todoc.database.DAO;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.concurrent.Executors;

/**
 * @author khalid
 */
@Database(entities = {Task.class, Project.class}, version = 1, exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

// --- SINGLETON ---
    private static volatile TodocDatabase INSTANCE;

    // --- DAO ---
    public abstract TaskDAO taskDao();

    public abstract ProjectDAO projectDao();

    // --- INSTANCE ---
    public static TodocDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TodocDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodocDatabase.class, "TodocDatabase.db")
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static Callback prepopulateDatabase() {
        return new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.projectDao().createProject(new Project(1, "DB", 0xFFB4CDBA)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.projectDao().createProject(new Project(2, "SQLite", 0xFFEADAD1)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.projectDao().createProject(new Project(3, "myApp", 0xFFA3CED2)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.projectDao().createProject(new Project(4, "towardsAI", 0xFFA3A3CE)));

                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(1, 1, "jkl", 2320)));
//                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(2, 2, "et534", 6538)));
//                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(3, 3, "Gazprom", 3785)));
//                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(4, 1, "NZairlines", 9877)));
//                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(5, 4, "Cyborg2028", 9850)));
//                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(6, 3, "mopuk", 6475)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task(7, 2, "VenezuelaOil", 843)));
            }
        };
    }
}

// Debug your database with the Database Inspector
// https://developer.android.com/studio/inspect/database