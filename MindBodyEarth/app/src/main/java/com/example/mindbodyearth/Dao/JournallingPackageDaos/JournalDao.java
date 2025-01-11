package com.example.mindbodyearth.Dao.JournallingPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal;

@Dao
public interface JournalDao {

    @Insert
    void insert(Journal journal);

    @Update
    void update(Journal journal);

    @Delete
    void delete(Journal journal);

    @Query("SELECT * FROM journal_table WHERE year = :year LIMIT 1")
    Journal getJournalByYear(int year);
}
