package com.example.hugogomez.firstapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by hugogomez on 15/03/2018.
 */

public class EducationScreenViewModel extends ViewModel {
    private LiveData<Education[]> education;

    public LiveData<Education[]> getEducation() {
        if (education == null) {
            education = new EducationLiveData();
        }
        return education;
    }
}
