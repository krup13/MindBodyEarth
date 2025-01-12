// MeditationVideos.java
package com.example.mindbodyearth.Entities.Meditation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meditation_video")
public class MeditationVideo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String youtubeLink;
    private boolean favorites;
    private String title;

    public MeditationVideo(URL youtubeLink, String title) {
        this.youtubeLink = youtubeLink.toString();
        this.title = title;
        this.favorites = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public String getTitle() {
        return title;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Methods
    public void play() {
        System.out.println("Playing video: " + title);
    }

    public void pause() {
        System.out.println("Pausing video: " + title);
    }

    public boolean labelFavorites(boolean favorites) {
        this.favorites = favorites;
        return this.favorites;
    }

    public static List<MeditationVideo> filterFavorites(List<MeditationVideo> videos) {
        List<MeditationVideo> favoriteVideos = new ArrayList<>();
        for (MeditationVideo video : videos) {
            if (video.isFavorites()) {
                favoriteVideos.add(video);
            }
        }
        return favoriteVideos;
    }
}
