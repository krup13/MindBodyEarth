// MeditationArticles.java
package com.example.mindbodyearth.Entities.Meditation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

@Entity(tableName = "meditation_article_table")
public class MeditationArticle {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "article_link")
    private String articleLink;

    @ColumnInfo(name = "favorites")
    private boolean favorites;

    @ColumnInfo(name = "title")
    private String title;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "bookmarks")
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
