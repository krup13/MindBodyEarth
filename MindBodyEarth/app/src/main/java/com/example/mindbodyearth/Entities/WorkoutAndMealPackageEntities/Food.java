package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class Food
{
    @PrimaryKey
    @ColumnInfo(name = "food_id")
    private long foodId;

    @ColumnInfo(name = "food_name")
    private String foodName;

    @ColumnInfo(name = "main_nutrient")
    private String mainNutrient;

    @ColumnInfo(name = "calories")
    private int calories;

    @ColumnInfo(name = "carbon_footprint")
    private double carbonFootprint;

    public Food(String foodName, String mainNutrient, int calories)
    {
        this.foodName = foodName;
        this.mainNutrient = mainNutrient;
        this.calories = calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories()
    {
        return calories;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName()
    {
        return foodName;
    }

    public void setMainNutrient(String mainNutrient) {
        this.mainNutrient = mainNutrient;
    }

    public String getMainNutrient() {
        return mainNutrient;
    }

    public void setFoodId(long foodId)
    {
        this.foodId = foodId;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setCarbonFootprint(double carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    public double getCarbonFootprint() {
        return carbonFootprint;
    }
}
