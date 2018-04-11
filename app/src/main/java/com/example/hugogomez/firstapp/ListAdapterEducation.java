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

public class ListAdapterEducation extends RecyclerView.Adapter<ListAdapterEducation.EducationHolder> {

    private final Education[] educations;
    private final OnListItemClickListener listener;

    public ListAdapterEducation(Education[] educations, OnListItemClickListener listener) {
        this.educations = educations;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EducationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EducationHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item,
                                parent, false
                        ));
    }

    @Override
    public void onBindViewHolder(@NonNull EducationHolder holder, int position) {
        holder.bindValue(educations[position]);
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
        return educations.length;
    }

    public static class EducationHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private TextView techno;
        private ImageView image;

        public EducationHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.project_item_title);
            description = itemView.findViewById(R.id.project_item_description);
            techno = itemView.findViewById(R.id.project_item_techno);
            image = itemView.findViewById(R.id.project_item_image);
        }

        void bindValue(Education project) {
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
