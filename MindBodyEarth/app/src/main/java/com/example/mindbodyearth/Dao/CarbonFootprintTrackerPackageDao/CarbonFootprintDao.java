package com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.CarbonFootprint;
import java.util.List;

@Dao
public interface CarbonFootprintDao {
    @Insert
    void insertCarbonFootprint(CarbonFootprint carbonFootprint);

    @Update
    void updateCarbonFootprint(CarbonFootprint carbonFootprint);

    @Delete
    void deleteCarbonFootprint(CarbonFootprint carbonFootprint);

    @Query("SELECT * FROM carbon_footprint_table")
    List<CarbonFootprint> getAllFootprints();
}
