package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "journal_table")
public class Journal {

    @PrimaryKey
    @ColumnInfo(name = "year")
    private int year;

    public Journal(int year) {
        this.year = year;
    }

    // Getters and setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
