package com.example.hugogomez.firstapp;

import android.arch.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by hugogomez on 15/03/2018.
 */

public class ProjectLiveData extends MutableLiveData<Project[]> {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void onActive() {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Project> projects = new ArrayList<>();

                for(DataSnapshot user : dataSnapshot.getChildren()) {
                    projects.add(user.getValue(Project.class));
                }
                postValue(projects.toArray(new Project[projects.size()]));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        database.getReference("Project").addValueEventListener(listener);

    }

    public void onInactive() {

    }
}
