package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meal_table")
public class Meal
{
    private MealPlan mealPlan;

    @PrimaryKey
    @ColumnInfo(name = "meal_id")
    private long mealId;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "meal_composition")
    private List<Food> mealComposition;

    @ColumnInfo(name = "total_calories")
    private int totalCalories;

    @ColumnInfo(name = "days")
    private String day;

    @ColumnInfo(name = "timeOfDayConsumed")
    private String timeOfDayConsumed;

    public Meal()
    {
        mealComposition = new ArrayList<Food>();
    }

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
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

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void updateMeal (Food newFood)
    {
        mealComposition.add(newFood);
    }

    public int calculateMealCalories()
    {
        int mealCalories = 0;
        for(Food food: mealComposition)
        {
            mealCalories += food.getCalories();
        }
        return mealCalories;
    }

    public void editMealComposition(Food foodToAdd, Food foodToRemove)
    {
        mealComposition.remove(foodToRemove);
        mealComposition.add(foodToAdd);
    }

    public void addFoodToMeal(Food food){
        mealComposition.add(food);
    }

    public void removeFoodFromMeal(Food food){
        mealComposition.remove(food);
    }

    public List<Food> getMealComposition() {
        return mealComposition;
    }

    public void setMealComposition(List<Food> mealComposition) {
        this.mealComposition = mealComposition;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getMealFootprint() {
        double totalFootprint = 0.0;
        for (Food food : mealComposition) {
            // Assuming each Food object has a method to calculate its carbon footprint
            totalFootprint += food.getCarbonFootprint();
        }
        return totalFootprint;
    }
}
