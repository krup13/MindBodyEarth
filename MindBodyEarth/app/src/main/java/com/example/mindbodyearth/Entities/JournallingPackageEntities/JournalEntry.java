package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "journal_entry_table",
        foreignKeys = @ForeignKey(
                entity = Journal.class,
                parentColumns = "year",
                childColumns = "journalYear",
                onDelete = ForeignKey.CASCADE
        )
)
public class JournalEntry {

    @PrimaryKey
    @ColumnInfo(name = "journalId")
    private Long journalId;

    @ColumnInfo(name = "journalYear")
    private int journalYear;

    @ColumnInfo(name = "day")
    private String day;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;

    public JournalEntry(Long journalId, int journalYear, String day, Date date, String title, String content) {
        this.journalId = journalId;
        this.journalYear = journalYear;
        this.day = day;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    // Getters and setters
    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public int getJournalYear() {
        return journalYear;
    }

    public void setJournalYear(int journalYear) {
        this.journalYear = journalYear;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
