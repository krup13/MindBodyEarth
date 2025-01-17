package com.example.mindbodyearth.Entities.JournallingPackageEntities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class JournalWithJournalEntries {
    @Embedded
    public Journal journal;

    @Relation(
            parentColumn = "year",
            entityColumn = "journal_id")
    public List<JournalEntry> journalEntries;
}
