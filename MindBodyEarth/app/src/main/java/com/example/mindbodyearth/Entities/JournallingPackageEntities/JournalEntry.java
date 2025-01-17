package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity(tableName = "journal_entry_table")
public class JournalEntry {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "journal_id")
    private Long journalId;

    @NonNull
    @ColumnInfo(name = "journal_year")
    private int journalYear;

    @NonNull
    @ColumnInfo(name = "day")
    private String day;

    @NonNull
    @ColumnInfo(name = "date")
    @TypeConverters({Converters.class})
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

    public static List<JournalEntry> getEntriesForYear(int year, List<JournalEntry> entries) {
        List<JournalEntry> result = new ArrayList<>();
        for (JournalEntry entry : entries) {
            if (entry.getJournalYear() == year) {
                result.add(entry);
            }
        }
        return result;
    }

    public static List<JournalEntry> searchEntries(String query, List<JournalEntry> entries) {
        List<JournalEntry> result = new ArrayList<>();
        for (JournalEntry entry : entries) {
            if (entry.getTitle().contains(query) || entry.getDate().toString().contains(query)) {
                result.add(entry);
            }
        }
        return result;
    }

    public static JournalEntry findEntryByDateAndYear(long date, int year, List<JournalEntry> entries) {
        for (JournalEntry entry : entries) {
            if (entry.getDate().getTime() == date && entry.getJournalYear() == year) {
                return entry;
            }
        }
        return null;
    }
}
