package com.example.mindbodyearth.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mindbodyearth.CarbonFootprintTracker.CarbonFootprint;
import java.util.List;

@Dao
public interface CarbonFootprintDao {
    @Insert
    void insert(CarbonFootprint footprint);

    @Update
    void update(CarbonFootprint footprint);

    @Delete
    void delete(CarbonFootprint footprint);

    @Query("SELECT * FROM carbon_footprint")
    List<CarbonFootprint> getAllFootprints();
}