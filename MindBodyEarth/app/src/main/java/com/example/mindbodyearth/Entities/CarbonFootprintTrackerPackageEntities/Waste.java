package com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "waste_table")
public class Waste {
    @ColumnInfo(name = "waste_generated")
    private double wasteGenerated;

    @ColumnInfo(name = "recycling_rate")
    private double recyclingRate;

    // Constructor
    public Waste(double wasteGenerated, double recyclingRate) {
        this.wasteGenerated = wasteGenerated;
        this.recyclingRate = recyclingRate;
    }

    // Getters
    public double getWasteGenerated() {
        return wasteGenerated;
    }

    public double getRecyclingRate() {
        return recyclingRate;
    }

    // Setters
    public void setWasteGenerated(double wasteGenerated) {
        this.wasteGenerated = wasteGenerated;
    }

    public void setRecyclingRate(double recyclingRate) {
        this.recyclingRate = recyclingRate;
    }

    // Method
    public double calcWasteFootprint() {
        // Implement calculation logic
        return wasteGenerated * (1 - recyclingRate);
    }
}
