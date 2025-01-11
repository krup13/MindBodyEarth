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
    void insert(JournalEntry journalEntry);

    @Update
    void update(JournalEntry journalEntry);

    @Delete
    void delete(JournalEntry journalEntry);

    @Query("SELECT * FROM journal_entry_table WHERE date = :date LIMIT 1")
    JournalEntry findJournalEntryByDate(Date date);

    @Query("SELECT * FROM journal_entry_table")
    List<JournalEntry> getAllEntries();

    @Query("SELECT * FROM journal_entry_table WHERE journalYear = :year")
    List<JournalEntry> getEntriesForYear(int year);

    @Query("SELECT * FROM journal_entry_table WHERE title LIKE :query OR date LIKE :query")
    List<JournalEntry> searchEntries(String query);

    @Query("SELECT * FROM journal_entry_table WHERE date = :date AND journalYear = :year LIMIT 1")
    JournalEntry findEntryByDateAndYear(long date, int year);

}
