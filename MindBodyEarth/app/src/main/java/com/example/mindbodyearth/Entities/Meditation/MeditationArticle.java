package com.example.mindbodyearth.Entities.Meditation;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mindbodyearth.Converters;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meditation_articles")
public class MeditationArticle {

    @androidx.annotation.NonNull
    @PrimaryKey(autoGenerate = true)
    @androidx.room.ColumnInfo(name = "article_id")
    private int id;

    @ColumnInfo(name = "article_link")
    private String articleLink;

    @ColumnInfo(name = "favorites")
    private boolean favorites;

    @ColumnInfo(name = "title")
    private String title;

    @androidx.room.TypeConverters({Converters.class})
    @androidx.room.ColumnInfo(name = "bookmarks")
    private List<Integer> bookmarks;

    public MeditationArticle(URL articleLink, String title) {
        this.articleLink = articleLink.toString();
        this.title = title;
        this.favorites = false;
        this.bookmarks = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getBookmarks() {
        return new ArrayList<>(bookmarks);
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookmarks(List<Integer> bookmarks) {
        this.bookmarks = bookmarks;
    }

    // Methods
    public boolean labelFavorites(boolean favorites) {
        this.favorites = favorites;
        return this.favorites;
    }

    public void bookmark(int line) {
        bookmarks.add(line);
    }

    public static List<MeditationArticle> filterFavoriteArticles(List<MeditationArticle> articles) {
        List<MeditationArticle> favoriteArticles = new ArrayList<>();
        for (MeditationArticle article : articles) {
            if (article.isFavorites()) {
                favoriteArticles.add(article);
            }
        }
        return favoriteArticles;
    }
}
