package com.example.mindbodyearth.Entities.Meditation;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meditation_articles")
public class MeditationArticle {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String articleLink;
    private boolean favorites;
    private String title;
    private String bookmarks;

    // Getters and Setters
}
