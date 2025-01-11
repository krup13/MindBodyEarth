package com.example.mindbodyearth.Entities.Meditation;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mindbodyearth.Dao.MeditationDaos.MeditationVideoDao;

import java.util.List;

@Entity(tableName = "meditation_videos")
public class MeditationVideo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "youtube_link")
    private String youtubeLink;

    @ColumnInfo(name = "favorites")
    private boolean favorites;

    @ColumnInfo(name = "title")
    private String title;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //functions

}
