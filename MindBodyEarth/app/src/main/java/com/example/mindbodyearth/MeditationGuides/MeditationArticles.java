// MeditationArticles.java
package com.example.mindbodyearth.MeditationGuides;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meditation_articles")
public class MeditationArticles {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String articleLink;
    private boolean favorites;
    private String title;
    private List<Integer> bookmarks;

    public MeditationArticles(URL articleLink, String title) {
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

    public static List<MeditationArticles> filterFavoriteArticles(List<MeditationArticles> articles) {
        List<MeditationArticles> favoriteArticles = new ArrayList<>();
        for (MeditationArticles article : articles) {
            if (article.isFavorites()) {
                favoriteArticles.add(article);
            }
        }
        return favoriteArticles;
    }
}
