package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.core.text.util.LocalePreferences;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "journal_entry_table")
public class JournalEntry {
    @PrimaryKey
    @ColumnInfo (name = "journalId")
    private Long journalId;

    @ColumnInfo (name = "day")
    private LocalePreferences.FirstDayOfWeek.Days day;

    @ColumnInfo (name = "date")
    private Date date;

    @ColumnInfo (name = "title")
    private String title;
    @ColumnInfo (name = "content")
    private String content;

    public JournalEntry(Long journalId, LocalePreferences.FirstDayOfWeek.Days day, Date date, String title, String content) {
        this.journalId = journalId;
        this.day = day;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    // Getters
    public Long getJournalId() {
        return journalId;
    }

    public LocalePreferences.FirstDayOfWeek.Days getDay() {
        return day;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Setters
    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public void setDay(LocalePreferences.FirstDayOfWeek.Days day) {
        this.day = day;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

}