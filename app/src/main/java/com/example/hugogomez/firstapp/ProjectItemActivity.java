package com.example.hugogomez.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hugogomez on 14/03/2018.
 */

public class ProjectItemActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_item);

        Project project = getIntent().getParcelableExtra("project");

    }

}
