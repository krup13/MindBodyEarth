package com.example.mindbodyearth.Entities.CarbonFootprint;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "carbon_footprint")
public class CarbonFootprint {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double totalFootprint;
    private double energyFootprint;
    private double transportFootprint;
    private double mealFootprint;
    private double wasteFootprint;

    // Getters and Setters
}
