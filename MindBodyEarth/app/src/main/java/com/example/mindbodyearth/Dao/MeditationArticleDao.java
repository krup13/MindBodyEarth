package com.example.mindbodyearth.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mindbodyearth.MeditationGuides.MeditationArticles;
import java.util.List;

@Dao
public interface MeditationArticleDao {
    @Insert
    void insert(MeditationArticles article);

    @Update
    void update(MeditationArticles article);

    @Delete
    void delete(MeditationArticles article);

    @Query("SELECT * FROM meditation_articles WHERE favorites = 1")
    List<MeditationArticles> getFavoriteArticles();
}