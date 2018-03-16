package com.example.hugogomez.firstapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hugogomez on 13/03/2018.
 */

public class Project implements Parcelable {
    private String title;
    private String description;
    private String techno;
    private String image;
    private String color;

    public Project() {
    }

    public Project(String title, String description, String techno, String image, String color) {
        this.title = title;
        this.description = description;
        this.techno = techno;
        this.image = image;
        this.color = color;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTechno() {
        return this.techno;
    }

    public String getImage() {
        return this.image;
    }

    public String getColor() {
        return this.color;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.techno);
        dest.writeString(this.image);
        dest.writeString(this.color);
    }

    protected Project(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.techno = in.readString();
        this.image = in.readString();
        this.color = in.readString();
    }

    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
}
