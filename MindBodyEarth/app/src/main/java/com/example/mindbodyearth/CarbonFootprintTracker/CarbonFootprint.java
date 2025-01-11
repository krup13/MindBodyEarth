package com.example.mindbodyearth.CarbonFootprintTracker;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalFootprint() {
        return totalFootprint;
    }

    public void setTotalFootprint(double totalFootprint) {
        this.totalFootprint = totalFootprint;
    }

    public double getEnergyFootprint() {
        return energyFootprint;
    }

    public void setEnergyFootprint(double energyFootprint) {
        this.energyFootprint = energyFootprint;
    }

    public double getTransportFootprint() {
        return transportFootprint;
    }

    public void setTransportFootprint(double transportFootprint) {
        this.transportFootprint = transportFootprint;
    }

    public double getMealFootprint() {
        return mealFootprint;
    }

    public void setMealFootprint(double mealFootprint) {
        this.mealFootprint = mealFootprint;
    }

    public double getWasteFootprint() {
        return wasteFootprint;
    }

    public void setWasteFootprint(double wasteFootprint) {
        this.wasteFootprint = wasteFootprint;
    }

    // Methods to calculate footprints
    public double calcTotalFootprint() {
        totalFootprint = energyFootprint + transportFootprint + mealFootprint + wasteFootprint;
        return totalFootprint;
    }

    public double calcEnergyFootprint(double energyUsage) {
        // Example calculation: 0.5 units per energy usage
        energyFootprint = energyUsage * 0.5;
        return energyFootprint;
    }

    public double calcTransportFootprint(double distance) {
        // Example calculation: 0.3 units per km traveled
        transportFootprint = distance * 0.3;
        return transportFootprint;
    }

    public double calcMealFootprint(double meals) {
        // Example calculation: 1.2 units per meal
        mealFootprint = meals * 1.2;
        return mealFootprint;
    }

    public double calcWasteFootprint(double wasteAmount) {
        // Example calculation: 0.8 units per kg of waste
        wasteFootprint = wasteAmount * 0.8;
        return wasteFootprint;
    }
}
