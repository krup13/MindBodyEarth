package com.example.mindbodyearth.Dao.JournallingPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry;

import java.util.List;

@Dao
public interface JournalDao {

    @Insert
    void insertJournal(Journal journal);

    @Update
    void updateJournal(Journal journal);

    @Delete
    void deleteJournal(Journal journal);

    @Query("SELECT * FROM journal_table")
    public List<JournalEntry> getAllEntries();

    //get all entries for a specific year
//    @Query("SELECT * FROM journal_table WHERE year = :year")
//    public List<JournalEntry> getEntriesByYear(int year);

    @Transaction
    @Query("SELECT * FROM journal_table WHERE year = :year")
    public Journal getJournalByYear(int year);

    @Transaction
    @Query("SELECT * FROM journal_table")
    public List<Journal> getJournalsWithJournalEntries();
}
