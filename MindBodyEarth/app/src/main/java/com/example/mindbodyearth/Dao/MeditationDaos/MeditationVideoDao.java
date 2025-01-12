package com.example.mindbodyearth.Dao.MeditationDaos
        ;

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
    void insertMeditationVideo(MeditationVideo video);

    @Update
    void updateMeditationVideo(MeditationVideo video);

    @Delete
    void deleteMeditationVideo(MeditationVideo video);

    @Query("SELECT * FROM MeditationVideo WHERE favorites = 1")
    List<MeditationVideo> getFavoriteVideos();
}
