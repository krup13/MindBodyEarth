package com.example.mindbodyearth.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mindbodyearth.Entities.Meditation.MeditationArticle;
import java.util.List;

@Dao
public interface MeditationArticleDao {
    @Insert
    void insert(MeditationArticle article);

    @Update
    void update(MeditationArticle article);

    @Delete
    void delete(MeditationArticle article);

    @Query("SELECT * FROM MeditationArticle WHERE favorites = 1")
    List<MeditationArticle> getFavoriteArticles();
}