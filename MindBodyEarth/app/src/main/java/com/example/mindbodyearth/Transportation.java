package com.example.mindbodyearth;

public class Transportation {
    private String modeOfTransport;
    private double distanceTravelled;
    private double fuelEfficiency;

    // Constructor
    public Transportation(String modeOfTransport, double distanceTravelled, double fuelEfficiency) {
        this.modeOfTransport = modeOfTransport;
        this.distanceTravelled = distanceTravelled;
        this.fuelEfficiency = fuelEfficiency;
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