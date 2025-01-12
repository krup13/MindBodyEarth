package com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "energy_consumption_table")
public class EnergyConsumption {
    // Attributes
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "electricity_usage")
    private double electricityUsage;

    @ColumnInfo(name = "gas_usage")
    private double gasUsage;

    // Constructor
    public EnergyConsumption(double electricityUsage, double gasUsage) {
        this.electricityUsage = electricityUsage;
        this.gasUsage = gasUsage;
    }

    // Getters
    @NonNull
    public Date getDate() {
        return date;
    }
    public double getElectricityUsage() {
        return electricityUsage;
    }

    public double getGasUsage() {
        return gasUsage;
    }

    // Setters

    public void setDate(@NonNull Date date) {
        this.date = date;
    }
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