package com.example.mindbodyearth.Entities.CarbonFootprint;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transportation")
public class Transportation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String modeOfTransport;
    private double distanceTravelled;
    private double fuelEfficiency;

    // Getters and Setters
}
