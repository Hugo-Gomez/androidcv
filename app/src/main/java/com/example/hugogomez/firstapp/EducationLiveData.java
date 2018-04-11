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

public class EducationLiveData extends MutableLiveData<Education[]> {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void onActive() {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Education> educations = new ArrayList<>();

                for(DataSnapshot user : dataSnapshot.getChildren()) {
                    educations.add(user.getValue(Education.class));
                }
                postValue(educations.toArray(new Education[educations.size()]));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        database.getReference("Education").addValueEventListener(listener);

    }

    public void onInactive() {

    }
}
