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

//    @Query("SELECT * FROM carbon_footprint_table")
//    List<CarbonFootprint> getAllFootprints();

    @Query("SELECT (COALESCE(energy_footprint, 0) + COALESCE(transportation_footprint, 0) + COALESCE(meal_footprint, 0) + COALESCE(waste_footprint, 0)) AS total_footprint FROM carbon_footprint_table WHERE date = date('now')")
    double getTotalFootprint();

    //other queries to obtain the other infos about carbon footprint
    //the query to obtain the biggest contributor to the carbon footprint
    //SELECT
    //    CASE
    //        WHEN energy_footprint >= transportation_footprint AND energy_footprint >= meal_footprint AND energy_footprint >= waste_footprint THEN 'Energy'
    //        WHEN transportation_footprint >= energy_footprint AND transportation_footprint >= meal_footprint AND transportation_footprint >= waste_footprint THEN 'Transportation'
    //        WHEN meal_footprint >= energy_footprint AND meal_footprint >= transportation_footprint AND meal_footprint >= waste_footprint THEN 'Meal'
    //        ELSE 'Waste'
    //    END AS biggest_contributor
    //FROM carbon_footprint_table
    //WHERE date = date('now'); -- Or specify a specific date range

    @Query("SELECT energy_footprint FROM carbon_footprint_table WHERE date = date('now') ")
    double getEnergyFootprint();

    @Query("SELECT transportation_footprint FROM carbon_footprint_table WHERE date = date('now')")
    double getTransportationFootprint();

    @Query("SELECT meal_footprint FROM carbon_footprint_table WHERE date = date('now')")
    double getMealFootprint();

    @Query("SELECT waste_footprint FROM carbon_footprint_table WHERE date = date('now')")
    double getWasteFootprint();
}
