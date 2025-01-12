package com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "transportation_table")
public class Transportation {
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
        return distanceTravelled / fuelEfficiency; // Implement calculation logic
    }
}