package com.example.mindbodyearth.MentalHealth;

import java.util.Date;

public class JournalEntry {
    private String journalId;
    private String day;
    private Date date;
    private String title;
    private String content;

    public JournalEntry(String journalId, String day, Date date, String title, String content) {
        this.journalId = journalId;
        this.day = day;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    // Getters
    public String getJournalId() {
        return journalId;
    }

    public String getDay() {
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
    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public void setDay(String day) {
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