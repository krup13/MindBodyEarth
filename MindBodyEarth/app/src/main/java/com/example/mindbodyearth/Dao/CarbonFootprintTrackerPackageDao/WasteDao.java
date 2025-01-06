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
    void insert(Waste waste);

    @Update
    void update(Waste waste);

    @Delete
    void delete(Waste waste);

    //@Query()
    double calcWasteFootprint();
}
