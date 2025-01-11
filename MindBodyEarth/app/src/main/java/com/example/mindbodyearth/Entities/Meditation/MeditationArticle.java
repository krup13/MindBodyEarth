package com.example.mindbodyearth.Entities.Meditation;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meditation_articles")
public class MeditationArticle {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "article_link")
    private String articleLink;

    @ColumnInfo(name = "favorites")
    private boolean favorites;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "bookmarks")
    private String bookmarks;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(String bookmarks) {
        this.bookmarks = bookmarks;
    }

    //functions

    //get links of Article with keyword in the title
    public List<String> getArticleLinksByKeyword(String keyword) {
        List<String> matchingLinks = new ArrayList<>();
        if (title != null && title.contains(keyword)) {
            matchingLinks.add(articleLink);
        }
        return matchingLinks;
    }
}
