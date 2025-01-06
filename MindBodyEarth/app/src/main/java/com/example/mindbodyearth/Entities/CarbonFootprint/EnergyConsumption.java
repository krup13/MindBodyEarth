package com.example.mindbodyearth.Entities.CarbonFootprint;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "energy_consumption")
public class EnergyConsumption {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double electricityUsage;
    private double gasUsage;

    // Getters and Setters
}
