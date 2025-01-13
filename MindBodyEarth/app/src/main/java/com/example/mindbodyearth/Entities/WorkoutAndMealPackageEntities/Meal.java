package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meal_table")
public class Meal {
    @TypeConverters({Converters.class})
    @ColumnInfo(name = "meal_composition")
    private List<Food> mealComposition;

    public void setMealComposition(List<Food> mealComposition){this.mealComposition=mealComposition;}

    @PrimaryKey
    @ColumnInfo(name = "total_calories")
    private int totalCalories;

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    @ColumnInfo(name = "timeOfDayConsumed")
    private String timeOfDayConsumed;

    public Meal()
    {
        mealComposition = new ArrayList<>();
    }

    public void editMeal (Food newFood)
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

    public void addFood(Food food)
    {
        mealComposition.add(food);
        totalCalories += food.getCalories();
    }

    public List<Food> getMealComposition()
    {
        return mealComposition;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
    public String getTimeOfDayConsumed()
    {
        return timeOfDayConsumed;
    }
    public void setTimeOfDayConsumed(String timeOfDayConsumed)
    {
        this.timeOfDayConsumed = timeOfDayConsumed;
    }
}
