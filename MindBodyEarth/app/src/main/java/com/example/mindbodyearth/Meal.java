package com.example.mindbodyearth;

import java.util.ArrayList;
import java.util.List;

public class Meal
{
    private List<Food> mealComposition;
    private int totalCalories;
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
