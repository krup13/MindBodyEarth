package com.example.mindbodyearth.Entities.CarbonFootprint;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "waste")
public class Waste {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double wasteGenerated;
    private double recyclingRate;

    // Getters and Setters
}
