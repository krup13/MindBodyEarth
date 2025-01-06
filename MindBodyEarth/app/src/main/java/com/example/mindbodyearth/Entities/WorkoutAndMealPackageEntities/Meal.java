package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meal_table")
public class Meal
{
    private MealPlan mealPlan;

    @PrimaryKey
    @ColumnInfo(name = "meal_id")
    private long mealId;

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
        mealComposition = new ArrayList<>();
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

    public int getTotalCalories() {
        return totalCalories;
    }
}
