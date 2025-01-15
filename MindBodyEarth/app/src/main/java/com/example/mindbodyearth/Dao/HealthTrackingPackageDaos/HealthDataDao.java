package com.example.mindbodyearth.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.HealthTrackerPackageEntities.HealthData;

import java.util.List;

@Dao
public interface HealthDataDao {

    @Insert
    void insertHealthData(HealthData healthData);

    @Update
    void updateHealthData(HealthData healthData);

    @Delete
    void deleteHealthData(HealthData healthData);

    @Query("SELECT * FROM health_data_table ORDER BY date DESC")
    List<HealthData> getAllHealthData();
}