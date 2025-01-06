package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "journal_table")
public class Journal {

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
}
