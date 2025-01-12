package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "journal_table")
public class Journal {

    @NonNull
    @PrimaryKey
    @ColumnInfo (name = "year")
    private Year year;

    @ColumnInfo (name = "entries")
    private List<JournalEntry> entries;

    public Journal() {
        this.entries = new ArrayList<>();
    }

    // Add a new journal entry
    public void addEntry(JournalEntry entry) {
        entries.add(entry);
    }

    // Remove a journal entry
    public void removeEntry(JournalEntry entry) {
        entries.remove(entry);
    }

    // Get all journal entries
    public List<JournalEntry> getAllEntries() {
        return new ArrayList<>(entries); // Return a copy
    }

    // Get all journal entries for a specific year
    public List<JournalEntry> getEntriesByYear(int year) {
        List<JournalEntry> entriesByYear = new ArrayList<>();
        for (JournalEntry entry : entries) {
            if (entry.getDate().getYear() == year) {
                entriesByYear.add(entry);
            }
        }
        return entriesByYear;
    }
}
