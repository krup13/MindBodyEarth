package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meal_table")
public class Meal
{
    @ColumnInfo(name = "meal_composition")
    private List<Food> mealComposition;

    @ColumnInfo(name = "total_calories")
    private int totalCalories;

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
        
    }
}
