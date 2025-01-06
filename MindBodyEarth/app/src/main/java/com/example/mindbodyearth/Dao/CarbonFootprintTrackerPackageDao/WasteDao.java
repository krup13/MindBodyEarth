package com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Waste;

@Dao
public interface WasteDao {
    @Insert
    void insertWaste(Waste waste);

    @Update
    void updateWaste(Waste waste);

    @Delete
    void deleteWaste(Waste waste);

    //@Query()
    double calcWasteFootprint();
}
