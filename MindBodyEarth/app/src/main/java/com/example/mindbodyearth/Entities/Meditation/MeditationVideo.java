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

    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for youtubeLink
    public String getYoutubeLink() {
        return youtubeLink;
    }
    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    // Getter and Setter for favorites
    public boolean isFavorites() {
        return favorites;
    }
    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
