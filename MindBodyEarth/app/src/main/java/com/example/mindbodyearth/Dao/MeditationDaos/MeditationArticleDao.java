package com.example.mindbodyearth.Dao.MeditationDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mindbodyearth.entities.meditation.MeditationArticle;
import java.util.List;

@Dao
public interface MeditationArticleDao {
    @Insert
    void insertMeditationArticle(MeditationArticle article);

    @Update
    void updateMeditationArticle(MeditationArticle article);

    @Delete
    void deleteMeditationArticle(MeditationArticle article);

    @Query("SELECT * FROM meditation_articles WHERE favorites = 1")
    List<MeditationArticle> getFavoriteArticles();
}
