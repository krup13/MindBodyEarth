package com.example.mindbodyearth;

import java.util.ArrayList;
import java.util.List;

public class MealPlan
{
    private List<Meal> meals;
    private String day;

    public MealPlan(String day)
    {
        this.meals = new ArrayList<>();
        this.day = day;
    }

    public void addMeal(Meal meal)
    {
        meals.add(meal);
    }

    public List<Meal> getMeals()
    {
        return meals;
    }

    public String getDay()
    {
        return day;
    }
}
