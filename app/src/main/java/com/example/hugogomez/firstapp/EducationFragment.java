package com.example.hugogomez.firstapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hugogomez on 14/03/2018.
 */

public class EducationFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private RecyclerView list;
    private ProgressBar progressbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_projects, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = view.findViewById(R.id.projects_list);
        progressbar = view.findViewById(R.id.projects_progressbar);
        // Récupérer le ViewModel
        EducationScreenViewModel vm =
                ViewModelProviders.of(this).get(EducationScreenViewModel.class);

        // Ecouter les données
        vm.getEducation().observe(this, new Observer<Education[]>() {
            @Override
            public void onChanged(@Nullable Education[] educations) {
                list.setLayoutManager(new LinearLayoutManager(getActivity()));
                list.setAdapter(new ListAdapterEducation(educations, position -> {
                    Intent intent = new Intent(getActivity(), EducationScreenViewModel.class);
                    startActivity(intent);
                }));
                progressbar.setVisibility(View.GONE);
                list.setVisibility(View.VISIBLE);
            }
        });

    }
}
