package com.example.mindbodyearth.Dao.JournallingPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry;

import java.util.List;

@Dao
public interface JournalEntryDao {
    @Insert
    void insertJournalEntry(JournalEntry journalEntry);

    @Update
    void updateJournalEntry(JournalEntry journalEntry);

    @Delete
    void deleteJournalEntry(JournalEntry journalEntry);

    //edit the content of a journal entry
    @Query("UPDATE journal_entry_table SET content = :content WHERE journalId = :journalId")
    void setContent(Long journalId, String content);

}
