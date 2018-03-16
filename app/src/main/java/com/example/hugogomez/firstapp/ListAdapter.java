package com.example.hugogomez.firstapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ProjectHolder> {

    private final Project[] projects;
    private final OnListItemClickListener listener;

    public ListAdapter(Project[] projects, OnListItemClickListener listener) {
        this.projects = projects;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item,
                                parent, false
                        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectHolder holder, int position) {
        holder.bindValue(projects[position]);
        holder.itemView.setOnClickListener(new
           View.OnClickListener() {
               public void onClick(View v) {
                   listener.onItemClicked(
                           holder.getAdapterPosition());
               }
           });
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    public static class ProjectHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private TextView techno;
        private ImageView image;

        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.project_item_title);
            description = itemView.findViewById(R.id.project_item_description);
            techno = itemView.findViewById(R.id.project_item_techno);
            image = itemView.findViewById(R.id.project_item_image);
        }

        void bindValue(Project project) {
            Drawable drawable = techno.getBackground();
            drawable.setColorFilter(Color.parseColor(project.getColor()), PorterDuff.Mode.SRC_IN);
            title.setText(project.getTitle());
            description.setText(project.getDescription());
            techno.setText(project.getTechno());
            Picasso.get().load(project.getImage()).into(image);
        }

    }

    public interface OnListItemClickListener {
        void onItemClicked(int position);
    }
}
