package com.example.mindbodyearth.Dao.JournallingPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry;

import java.util.Date;
import java.util.List;

@Dao
public interface JournalEntryDao {

    @Insert
    void insertJournalEntry(JournalEntry journalEntry);

    @Update
    void updateJournalEntry(JournalEntry journalEntry);

    @Delete
    void deleteJournalEntry(JournalEntry journalEntry);

    @Query("SELECT * FROM journal_entry_table WHERE date = :date LIMIT 1")
    JournalEntry findJournalEntryByDate(Date date);

    @Query("SELECT * FROM journal_entry_table")
    List<JournalEntry> getAllEntries();

    @Query("UPDATE journal_entry_table SET content = :content WHERE journal_id = :journalId")
    void setContent(Long journalId, String content);

    @Query("SELECT * FROM journal_entry_table WHERE journal_year = :year")
    List<JournalEntry> getEntriesForYear(int year);

    @Query("SELECT * FROM journal_entry_table WHERE title LIKE :query OR date LIKE :query")
    List<JournalEntry> searchEntries(String query);

    @Query("SELECT * FROM journal_entry_table WHERE date = :date AND journal_year = :year LIMIT 1")
    JournalEntry findEntryByDateAndYear(long date, int year);

}
