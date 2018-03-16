package com.example.hugogomez.firstapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by hugogomez on 15/03/2018.
 */

public class ProjectScreenViewModel extends ViewModel {
    private LiveData<Project[]> project;

    public LiveData<Project[]> getProject() {
        if (project == null) {
            project = new ProjectLiveData();
        }
        return project;
    }
}
