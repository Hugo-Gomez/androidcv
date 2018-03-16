package com.example.hugogomez.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by hugogomez on 14/03/2018.
 */

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Date d'anniversaire
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.DAY_OF_MONTH, 9);
        birthday.set(Calendar.MONTH, 10);
        birthday.set(Calendar.YEAR, 1997);

        // Aujourd'hui
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

        TextView ageText = view.findViewById(R.id.whoiam_age);
        ageText.setText(getString(R.string.age, age));

        final ImageView facebook = view.findViewById(R.id.whoiam_fb);
        facebook.setOnClickListener(v -> {
            Intent facebook_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fr-fr.facebook.com/"));
            startActivity(facebook_intent);
        });

        final ImageView twitter = view.findViewById(R.id.whoiam_twitter);
        twitter.setOnClickListener(v -> {
            Intent twitter_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/?lang=fr"));
            startActivity(twitter_intent);
        });

        final ImageView linkedin = view.findViewById(R.id.whoiam_linkedin);
        linkedin.setOnClickListener(v -> {
            Intent linkedin_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/hugo-gomez-5344aa121/"));
            startActivity(linkedin_intent);
        });
    }
}
