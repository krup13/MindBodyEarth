package com.example.mindbodyearth.CarbonFootprintTracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "waste")
public class Waste {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double wasteGenerated; // in kilograms
    private double recyclingRate; // percentage (0 to 100)

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWasteGenerated() {
        return wasteGenerated;
    }

    public void setWasteGenerated(double wasteGenerated) {
        this.wasteGenerated = wasteGenerated;
    }

    public double getRecyclingRate() {
        return recyclingRate;
    }

    public void setRecyclingRate(double recyclingRate) {
        if (recyclingRate < 0 || recyclingRate > 100) {
            throw new IllegalArgumentException("Recycling rate must be between 0 and 100.");
        }
        this.recyclingRate = recyclingRate;
    }

    // Method to calculate waste footprint
    public double calcWasteFootprint() {
        // Example calculation:
        // Assume non-recycled waste contributes 1.5 units of CO2 per kg
        double nonRecycledWaste = wasteGenerated * (1 - (recyclingRate / 100));
        return nonRecycledWaste * 1.5;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "id=" + id +
                ", wasteGenerated=" + wasteGenerated +
                ", recyclingRate=" + recyclingRate +
                '}';
    }
}
