package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.time.Year;

@Entity (tableName = "journal_table")
public class Journal {


    @NonNull
    @PrimaryKey
    @ColumnInfo (name = "year")
    @TypeConverters({Converters.class})
    private Year year;

//    @ColumnInfo (name = "entries")
//    @TypeConverters({Converters.class})
//    private List<JournalEntry> entries;

    public Journal() {
//        this.entries = new ArrayList<>();
    }

    public Year getYear() {
        return year;
    }

    public void setYear(@NonNull Year year) {
        this.year = year;
    }

    //    public List<JournalEntry> getEntries() {
//        return entries;
//    }
//
//    public void setEntries(List<JournalEntry> entries) {
//        this.entries = entries;
//    }

    // Add a new journal entry
//    public void addEntry(JournalEntry entry) {
//        entries.add(entry);
//    }
//
//    // Remove a journal entry
//    public void removeEntry(JournalEntry entry) {
//        entries.remove(entry);
//    }
//
//    // Get all journal entries
//    public List<JournalEntry> getAllEntries() {
//        return new ArrayList<>(entries); // Return a copy
//    }

    // Get all journal entries for a specific year
//    public List<JournalEntry> getEntriesByYear(int year) {
//        List<JournalEntry> entriesByYear = new ArrayList<>();
//        for (JournalEntry entry : entries) {
//            if (entry.getDate().getYear() == year) {
//                entriesByYear.add(entry);
//            }
//        }
//        return entriesByYear;
//    }
}
