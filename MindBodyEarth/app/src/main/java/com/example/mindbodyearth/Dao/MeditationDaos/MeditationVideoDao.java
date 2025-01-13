package com.example.mindbodyearth.Dao.MeditationDaos;

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

    @Query("SELECT * FROM meditation_video_table")
    List<MeditationVideo> getAllVideos();

    @Query("SELECT * FROM meditation_video_table WHERE id = :id")
    MeditationVideo getVideoById(int id);

    @Query("UPDATE meditation_video_table SET favorites = :favorites WHERE id = :id")
    void updateFavoriteStatus(int id, boolean favorites);

    @Query("SELECT * FROM meditation_video_table WHERE title LIKE :title")
    List<MeditationVideo> searchVideosByTitle(String title);
}
