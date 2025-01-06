package com.example.mindbodyearth.Entities.Meditation;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meditation_videos")
public class MeditationVideo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String youtubeLink;
    private boolean favorites;
    private String title;

    // Getters and Setters
}
