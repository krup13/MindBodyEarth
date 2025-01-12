package com.example.mindbodyearth.CarbonFootprintTracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transportation")
public class Transportation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String modeOfTransport; // e.g., Car, Bus, Train
    private double distanceTravelled; // in kilometers
    private double fuelEfficiency; // in km per liter (for vehicles)

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    // Method to calculate transport footprint
    public double calcTransportFootprint() {
        // Example calculation for vehicles:
        // Carbon footprint: 2.31 kg CO2 per liter of fuel consumed
        if (fuelEfficiency > 0) {
            double fuelConsumed = distanceTravelled / fuelEfficiency;
            return fuelConsumed * 2.31;
        }

        // Example calculation for other modes (default values can be adjusted based on research)
        switch (modeOfTransport.toLowerCase()) {
            case "bus":
                return distanceTravelled * 0.05; // 0.05 kg CO2 per km
            case "train":
                return distanceTravelled * 0.03; // 0.03 kg CO2 per km
            case "bicycle":
            case "walking":
                return 0; // No carbon footprint for these modes
            default:
                return distanceTravelled * 0.1; // Generic footprint for unknown modes
        }
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", modeOfTransport='" + modeOfTransport + '\'' +
                ", distanceTravelled=" + distanceTravelled +
                ", fuelEfficiency=" + fuelEfficiency +
                '}';
    }
}
