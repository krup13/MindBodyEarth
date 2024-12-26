package com.example.mindbodyearth;

public class Food
{
    private String foodName;
    private String mainNutrient;
    private int calories;

    public Food(String foodName, String mainNutrient, int calories)
    {
        this.foodName = foodName;
        this.mainNutrient = mainNutrient;
        this.calories = calories;
    }

    public int getCalories()
    {
        return calories;
    }

    public String getFoodName()
    {
        return foodName;
    }
}
