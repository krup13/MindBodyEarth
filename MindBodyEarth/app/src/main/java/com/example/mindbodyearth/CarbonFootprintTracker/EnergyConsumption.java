package com.example.mindbodyearth.CarbonFootprintTracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "energy_consumption")
public class EnergyConsumption {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double electricityUsage; // in kWh
    private double gasUsage; // in cubic meters

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getElectricityUsage() {
        return electricityUsage;
    }

    public void setElectricityUsage(double electricityUsage) {
        this.electricityUsage = electricityUsage;
    }

    public double getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(double gasUsage) {
        this.gasUsage = gasUsage;
    }

    // Method to calculate energy footprint
    public double calcEnergyFootprint() {
        // Example calculation:
        // Electricity footprint: 0.4 units per kWh
        // Gas footprint: 2.3 units per cubic meter
        double electricityFootprint = electricityUsage * 0.4;
        double gasFootprint = gasUsage * 2.3;
        return electricityFootprint + gasFootprint;
    }

    @Override
    public String toString() {
        return "EnergyConsumption{" +
                "id=" + id +
                ", electricityUsage=" + electricityUsage +
                ", gasUsage=" + gasUsage +
                '}';
    }
}
