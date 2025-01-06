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

    //@Query(SELECT * WHERE )
    double calcEnergyFootprint( );
}
