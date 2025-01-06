package com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "carbon_footprint_table")
public class CarbonFootprint {

    @ColumnInfo(name = "date")
    private String date; //format : dd/mm/yyyy

    @ColumnInfo(name = "total_footprint")
    private double totalFootprint;

    @ColumnInfo(name = "energy_footprint")
    private double energyFootprint;  // CO₂ emissions from energy usage

    @ColumnInfo(name = "transportation_footprint")
    private double transportFootprint;  // CO₂ emissions from transportation

    @ColumnInfo(name = "meal_footprint")
    private double mealFootprint;  // CO₂ emissions from food consumption

    @ColumnInfo(name = "waste_footprint")
    private double wasteFootprint;  // CO₂ emissions from waste generation

    // Constructor
    public CarbonFootprint(double energyFootprint, double transportFootprint, double mealFootprint, double wasteFootprint) {
        this.energyFootprint = energyFootprint;
        this.transportFootprint = transportFootprint;
        this.mealFootprint = mealFootprint;
        this.wasteFootprint = wasteFootprint;
        this.totalFootprint = calcTotalFootprint(); // Automatically calculate total footprint
    }

    // Default Constructor
    public CarbonFootprint() {
        this.energyFootprint = 0.0;
        this.transportFootprint = 0.0;
        this.mealFootprint = 0.0;
        this.wasteFootprint = 0.0;
        this.totalFootprint = 0.0;
    }

    // Getters and Setters
    public double getTotalFootprint() {
        return totalFootprint;
    }

    public double getEnergyFootprint() {
        return energyFootprint;
    }

    public void setEnergyFootprint(double energyFootprint) {
        this.energyFootprint = energyFootprint;
        updateTotalFootprint();
    }

    public double getTransportFootprint() {
        return transportFootprint;
    }

    public void setTransportFootprint(double transportFootprint) {
        this.transportFootprint = transportFootprint;
        updateTotalFootprint();
    }

    public double getMealFootprint() {
        return mealFootprint;
    }

    public void setMealFootprint(double mealFootprint) {
        this.mealFootprint = mealFootprint;
        updateTotalFootprint();
    }

    public double getWasteFootprint() {
        return wasteFootprint;
    }

    public void setWasteFootprint(double wasteFootprint) {
        this.wasteFootprint = wasteFootprint;
        updateTotalFootprint();
    }

    // Methods
    public double calcTotalFootprint() {
        // Sum of all individual footprints
        return energyFootprint + transportFootprint + mealFootprint + wasteFootprint;
    }

    private void updateTotalFootprint() {
        this.totalFootprint = calcTotalFootprint();
    }

    public double calcEnergyFootprint() {
        return energyFootprint; // Placeholder for more detailed energy calculation logic
    }

    public double calcTransportFootprint() {
        return transportFootprint; // Placeholder for more detailed transport calculation logic
    }

    public double calcMealFootprint() {
        return mealFootprint; // Placeholder for more detailed meal calculation logic
    }

    public double calcWasteFootprint() {
        return wasteFootprint; // Placeholder for more detailed waste calculation logic
    }

    @Override
    public String toString() {
        return "CarbonFootprint{" +
                "totalFootprint=" + totalFootprint + " kg CO₂" +
                ", energyFootprint=" + energyFootprint + " kg CO₂" +
                ", transportFootprint=" + transportFootprint + " kg CO₂" +
                ", mealFootprint=" + mealFootprint + " kg CO₂" +
                ", wasteFootprint=" + wasteFootprint + " kg CO₂" +
                '}';
    }
}


