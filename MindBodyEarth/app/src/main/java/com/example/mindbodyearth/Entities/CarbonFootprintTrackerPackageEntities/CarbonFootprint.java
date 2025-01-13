package com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;
import androidx.room.TypeConverters;
import com.example.mindbodyearth.Converters;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;

import java.sql.Date;

@Entity(tableName = "carbon_footprint_table")
public class CarbonFootprint {

    @Ignore
    private EnergyConsumption energyConsumption;
    @Ignore
    private Transportation transportation;
    @Ignore
    private Meal meal;
    @Ignore
    private Waste waste;

    @TypeConverters({Converters.class})
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "date")
    private Date date; //format : dd/mm/yyyy

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
    public CarbonFootprint(EnergyConsumption energy, Transportation transport, MealPlan mealFootprint, Waste waste) {
        this.energyFootprint = energy.calcEnergyFootprint();
        this.transportFootprint = transport.calcTransportFootprint();
        this.wasteFootprint = waste.calcWasteFootprint();
        this.mealFootprint = mealFootprint.calculateMealFootprint();
        this.date = new Date(System.currentTimeMillis());

        updateTotalFootprint();
    }

    // Default Constructor
    public CarbonFootprint() {
        this.energyFootprint = 0.0;
        this.transportFootprint = 0.0;
        this.mealFootprint = 0.0;
        this.wasteFootprint = 0.0;
        this.totalFootprint = 0.0;
    }

    private void updateTotalFootprint() {
        this.totalFootprint = energyFootprint + transportFootprint + mealFootprint + wasteFootprint;
    }

    // Getters for each footprint
    public double getTotalFootprint() {
        return totalFootprint;
    }

    public double getEnergyFootprint() {
        return energyFootprint;
    }

    public double getTransportFootprint() {
        return transportFootprint;
    }

    public double getMealFootprint() {
        return mealFootprint;
    }

    public double getWasteFootprint() {
        return wasteFootprint;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public EnergyConsumption getEnergyConsumption() {
        return energyConsumption;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public Meal getMeal() {
        return meal;
    }

    public Waste getWaste() {
        return waste;
    }

    // Setters for each field
    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public void setEnergyConsumption(EnergyConsumption energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    public void setEnergyFootprint(double energyFootprint) {
        this.energyFootprint = energyFootprint;
        updateTotalFootprint();
    }

    public void setTransportFootprint(double transportFootprint) {
        this.transportFootprint = transportFootprint;
        updateTotalFootprint();
    }

    public void setMealFootprint(double mealFootprint) {
        this.mealFootprint = mealFootprint;
        updateTotalFootprint();
    }

    public void setWasteFootprint(double wasteFootprint) {
        this.wasteFootprint = wasteFootprint;
        updateTotalFootprint();
    }

    public void setTotalFootprint(double totalFootprint) {
        // No operation or optional: throw exception to indicate it shouldn't be set directly
    }


    @NonNull
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


