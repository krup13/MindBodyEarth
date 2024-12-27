package com.example.mindbodyearth.MentalHealth;

import com.example.mindbodyearth.MentalHealth.JournalEntry;
import java.util.ArrayList;
import java.util.List;

public class JournalRepository {
    private List<JournalEntry> journalEntries;

    public JournalRepository() {
        this.journalEntries = new ArrayList<>();
    }

    // Add a new journal entry
    public void addEntry(JournalEntry entry) {
        journalEntries.add(entry);
    }

    // Get all journal entries
    public List<JournalEntry> getAllEntries() {
        return new ArrayList<>(journalEntries); // Return a copy
    }

    // Find entries by a keyword
    public List<JournalEntry> searchEntries(String keyword) {
        List<JournalEntry> results = new ArrayList<>();
        for (JournalEntry entry : journalEntries) {
            if (entry.getText().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(entry);
            }
        }
        return results;
    }
}
