package com.example.mindbodyearth.Journaling;

import java.util.ArrayList;
import java.util.List;

public class Journal {
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
