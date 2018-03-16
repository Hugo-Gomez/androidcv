package com.example.hugogomez.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hugogomez.firstapp.ListAdapter.OnListItemClickListener;

/**
 * Created by hugogomez on 13/03/2018.
 */

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        Project[] projects = new Project[] {
                new Project("Douche Simulator", "Le seul et unique simulateur de douche pour Android. Disponible sur le Google Play, il est entièrement gratuit !", "ANDROID", "https://images-na.ssl-images-amazon.com/images/I/81nhjzvbchL._SL1500_.jpg", "#ff0000"),
                new Project("BlaBlaSims", "Le seul et unique service de covoiturage entre Sims. Une manière écologique de partager ses frais !", "NODE JS", "https://images-na.ssl-images-amazon.com/images/I/81nhjzvbchL._SL1500_.jpg", "#ff9900")
        };

        RecyclerView list = findViewById(R.id.projects_list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ListAdapter(projects, new
                OnListItemClickListener() {
            public void onItemClicked(int position) {
                Intent intent = new Intent(getBaseContext(), ProjectItemActivity.class);
                //intent.putExtra("projet", new Project("Douche Simulator", "Le seul et unique simulateur de douche pour Android. Disponible sur le Google Play, il est entièrement gratuit !", "ANDROID", "https://images-na.ssl-images-amazon.com/images/I/81nhjzvbchL._SL1500_.jpg", "#ff0000"));
                startActivity(intent);
            }
        }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

