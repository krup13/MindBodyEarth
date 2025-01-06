package com.example.mindbodyearth;

public class Waste {
    private double wasteGenerated;
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
