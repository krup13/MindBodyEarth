package com.example.mindbodyearth.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mindbodyearth.MeditationGuides.MeditationVideos;
import java.util.List;

@Dao
public interface MeditationVideoDao {
    @Insert
    void insert(MeditationVideos video);

    @Update
    void update(MeditationVideos video);

    @Delete
    void delete(MeditationVideos video);

    @Query("SELECT * FROM meditation_videos WHERE favorites = 1")
    List<MeditationVideos> getFavoriteVideos();
}