package com.example.mindbodyearth;

public class EnergyConsumption {
    // Attributes
    private double electricityUsage;
    private double gasUsage;

    // Constructor
    public EnergyConsumption(double electricityUsage, double gasUsage) {
        this.electricityUsage = electricityUsage;
        this.gasUsage = gasUsage;
    }

    // Getters
    public double getElectricityUsage() {
        return electricityUsage;
    }

    public double getGasUsage() {
        return gasUsage;
    }

    // Setters
    public void setElectricityUsage(double electricityUsage) {
        this.electricityUsage = electricityUsage;
    }

    public void setGasUsage(double gasUsage) {
        this.gasUsage = gasUsage;
    }

    // Method
    public double calcEnergyFootprint() {
        return electricityUsage + (gasUsage * 29.3); // Assuming 1 therm = 29.3 kWh
    }
}