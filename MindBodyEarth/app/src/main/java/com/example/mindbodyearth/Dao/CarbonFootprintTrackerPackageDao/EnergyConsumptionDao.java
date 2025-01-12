package com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.EnergyConsumption;

@Dao
public interface EnergyConsumptionDao {
    @Insert
    void insertEnergyConsumption (EnergyConsumption energyConsumption);

    @Update
    void updateEnergyConsumption (EnergyConsumption energyConsumption);

    @Delete
    void deleteEnergyConsumption (EnergyConsumption energyConsumption);

    @Query("SELECT (electricity_usage + (gas_usage * 29.3)) AS energy_footprint FROM energy_consumption_table WHERE date = :date")
    double calcEnergyFootprint( );

    @Query("SELECT electricity_usage FROM energy_consumption_table WHERE date = :date")
    double getElectricityUsage(String date);

    @Query("SELECT gas_usage FROM energy_consumption_table WHERE date = :date")
    double getGasUsage(String date);

    @Query("SELECT date FROM energy_consumption_table WHERE date = :date")
    String getDate(String date);

    @Query("SELECT (electricity_usage + (gas_usage * 29.3)) AS energy_footprint FROM energy_consumption_table WHERE date = :date")
    double getEnergyFootprint(String date);
}
