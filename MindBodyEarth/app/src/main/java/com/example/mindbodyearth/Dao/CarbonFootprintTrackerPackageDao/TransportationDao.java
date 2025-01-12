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

    @Query("SELECT * FROM transportation_table")
    Transportation getTransportation();

    @Query("SELECT mode_of_transportation FROM transportation_table")
    String getModeOfTransportation();

    @Query("SELECT distance_travelled FROM transportation_table")
    double getDistanceTravelled();

    @Query("SELECT fuel_efficiency FROM transportation_table")
    double getFuelEfficiency();

    @Query("SELECT distance_travelled / fuel_efficiency FROM transportation_table")
    double calcTransportFootprint();


}
