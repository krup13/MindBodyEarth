package com.example.mindbodyearth.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.Meditation.MeditationVideo;

import java.util.List;

@Dao
public interface MeditationVideoDao {
    @Insert
    void insert(MeditationVideo video);

    @Update
    void update(MeditationVideo video);

    @Delete
    void delete(MeditationVideo video);

    @Query("SELECT * FROM meditation_video WHERE favorites = 1")
    List<MeditationVideo> getFavoriteVideos();
}
