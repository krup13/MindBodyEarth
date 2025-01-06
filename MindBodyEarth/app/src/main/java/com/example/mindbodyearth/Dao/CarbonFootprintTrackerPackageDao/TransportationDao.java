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
    void insert (Transportation transportation);

    @Update
    void update (Transportation transportation);

    @Delete
    void delete (Transportation transportation);

    //@Query()
    double calcTransportFootprint();
}
