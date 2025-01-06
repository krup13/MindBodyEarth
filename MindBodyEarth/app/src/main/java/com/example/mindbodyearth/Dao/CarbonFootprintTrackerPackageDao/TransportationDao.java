package com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Transportation;

@Dao
public interface TransportationDao {
    @Insert
    void insertTransportation (Transportation transportation);

    @Update
    void updateTransportation (Transportation transportation);

    @Delete
    void deleteTransportation (Transportation transportation);

    //@Query()
    double calcTransportFootprint();
}
