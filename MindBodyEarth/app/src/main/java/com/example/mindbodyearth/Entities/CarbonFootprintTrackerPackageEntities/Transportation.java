package com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.sql.Date;

@Entity(tableName = "transportation_table")
public class Transportation {

    @TypeConverters({Converters.class})
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "mode_of_transportation")
    private String modeOfTransport;

    @ColumnInfo(name = "distance_travelled")
    private double distanceTravelled;

    @ColumnInfo(name = "fuel_efficiency")
    private double fuelEfficiency;

    // Constructor
    public Transportation(String modeOfTransport, double distanceTravelled, double fuelEfficiency) {
        this.modeOfTransport = modeOfTransport;
        this.distanceTravelled = distanceTravelled;
        this.fuelEfficiency = fuelEfficiency;
    }

    @NonNull
    public Date getDate() {
        return date;
    }
    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }
    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    // Method
    public double calcTransportFootprint() {
        double emissionsFactor = 0.0;

        // Define CO₂ emissions factors for different fuel types
        if (modeOfTransport.equalsIgnoreCase("gasoline")) {
            emissionsFactor = 2.31; // kg CO₂ per liter for gasoline
        } else if (modeOfTransport.equalsIgnoreCase("diesel")) {
            emissionsFactor = 2.68; // kg CO₂ per liter for diesel
        } else {
            System.out.println("Unknown fuel type.");
            return 0.0; // Return 0 if fuel type is unknown
        }

        // Calculate carbon footprint
        double fuelConsumed = distanceTravelled / fuelEfficiency; // Calculate fuel consumed
        return fuelConsumed * emissionsFactor; // Return the total carbon footprint    }
    }
}