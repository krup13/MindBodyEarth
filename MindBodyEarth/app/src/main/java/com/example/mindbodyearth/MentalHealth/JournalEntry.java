package com.example.mindbodyearth.MentalHealth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JournalEntry {
    private String text;
    private long timestamp;

    public JournalEntry(String text, long timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    // Getters
    public String getText() {
        return text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    // Helper method to format timestamp as a readable date
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }
}
