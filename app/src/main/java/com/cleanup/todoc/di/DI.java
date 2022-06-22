package com.cleanup.todoc.di;

import android.content.Context;
import com.cleanup.todoc.database.DAO.TodocDatabase;
import com.cleanup.todoc.repository.TodocRepository;


/**
 * @author khalid
 */
public class DI {

    private static TodocRepository tRep = null;

    /**
     * Get an instance on @{@link TodocRepository}
     * @return
     */
    public static TodocRepository getTodocRepository(Context context) {
        if(tRep == null){
            TodocDatabase db = TodocDatabase.getInstance(context);
            tRep = new TodocRepository(db.projectDao(), db.taskDao());
        }
        return tRep;
    }

    /**
     * Get always a new instance on @{@link TodocRepository}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static TodocRepository getNewInstanceTodocRepository(Context context) {
        TodocDatabase db = TodocDatabase.getInstance(context);
        tRep = new TodocRepository(db.projectDao(), db.taskDao());
        return tRep;
    }
}
