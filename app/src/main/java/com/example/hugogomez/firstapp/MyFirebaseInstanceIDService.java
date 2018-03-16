package com.example.hugogomez.firstapp;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.HashMap;

/**
 * Created by hugogomez on 15/03/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {

        String token = FirebaseInstanceId.getInstance().getToken();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        HashMap<String, Object> map = new HashMap(3);
        map.put("Name", "Maggie");
        map.put("Age", 6);
        map.put("Token", token);

        Task<Void> task = database.getReference("Users/user_maggie").updateChildren(map);

        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override public void onSuccess(Void aVoid) { }
        });
        task.addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override public void onComplete(@NonNull Task<Void> task) { }
        });
        task.addOnFailureListener(new OnFailureListener() {
            @Override public void onFailure(@NonNull Exception e) { }
        });

    }

}
