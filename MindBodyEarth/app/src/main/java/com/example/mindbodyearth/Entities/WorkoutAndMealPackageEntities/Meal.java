package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

//import com.example.mindbodyearth.ArrayListTypeConverter;
import com.example.mindbodyearth.Converters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meal_table")
public class Meal
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "meal_id")
    private long mealId;

    @ColumnInfo(name = "meal_name")
    private String mealName;

    @ColumnInfo(name = "total_calories")
    private int totalCalories;

    @ColumnInfo(name = "days")
    private String day;

    @ColumnInfo(name = "time_of_day_consumed")
    private String timeOfDayConsumed;

    @ColumnInfo(name = "total_carbon_footprint")
    private double totalCarbonFootprint;

    public Meal() {}

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeOfDayConsumed() {
        return timeOfDayConsumed;
    }

    public void setTimeOfDayConsumed(String timeOfDayConsumed) {
        this.timeOfDayConsumed = timeOfDayConsumed;
    }

    public double getTotalCarbonFootprint() {
        return totalCarbonFootprint;
    }

    public void setTotalCarbonFootprint(double totalCarbonFootprint) {
        this.totalCarbonFootprint = totalCarbonFootprint;
    }

//    public MealPlan getMealPlan() {
//        return mealPlan;
//    }
//
//    public void setMealPlan(MealPlan mealPlan) {
//        this.mealPlan = mealPlan;
//    }
//
//    public void updateMeal (Food newFood)
//    {
//        mealComposition.add(newFood);
//    }
//
//    public int calculateMealCalories()
//    {
//        int mealCalories = 0;
//        for(Food food: mealComposition)
//        {
//            mealCalories += food.getCalories();
//        }
//        return mealCalories;
//    }
//
//    public void editMealComposition(Food foodToAdd, Food foodToRemove)
//    {
//        mealComposition.remove(foodToRemove);
//        mealComposition.add(foodToAdd);
//    }
//
//    public void addFoodToMeal(Food food){
//        mealComposition.add(food);
//    }
//
//    public void removeFoodFromMeal(Food food){
//        mealComposition.remove(food);
//    }
//
//    public double getMealFootprint() {
//        double totalFootprint = 0.0;
//        for (Food food : mealComposition) {
//            // Assuming each Food object has a method to calculate its carbon footprint
//            totalFootprint += food.getCarbonFootprint();
//        }
//        return totalFootprint;
//    }
}
