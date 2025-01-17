package com.example.mindbodyearth.Dao.MeditationDaos;

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
    void insertMeditationArticle(MeditationArticle article);

    @Update
    void updateMeditationArticle(MeditationArticle article);

    @Delete
    void deleteMeditationArticle(MeditationArticle article);

    @Query("SELECT * FROM meditation_articles")
    List<MeditationArticle> getAllArticles();

    @Query("SELECT * FROM meditation_articles WHERE article_id = :id")
    MeditationArticle getArticleById(int id);

    @Query("SELECT * FROM meditation_articles WHERE favorites = 1")
    List<MeditationArticle> getFavoriteArticles();

    @Query("UPDATE meditation_articles SET favorites = :favorites WHERE article_id = :id")
    void updateFavoriteStatus(int id, boolean favorites);

    @Query("UPDATE meditation_articles SET bookmarks = :bookmarks WHERE article_id = :id")
    void updateBookmarks(int id, List<Integer> bookmarks);
}
