package com.example.hugogomez.firstapp;

import android.app.Application;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.concurrent.TimeUnit;

/**
 * Created by hugogomez on 16/03/2018.
 */

public class StartApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        remoteConfig.setConfigSettings(configSettings);
        remoteConfig.fetch(BuildConfig.DEBUG ? 0 : TimeUnit.DAYS.toMillis(1))
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        remoteConfig.activateFetched();
                    }
                });
        String phone_number = remoteConfig.getString("menu_phone");
        String email = remoteConfig.getString("menu_email");
        String twitter = remoteConfig.getString("whoiam_twitter");
        String linkedin = remoteConfig.getString("whoiam_linkedin");
    }
}
