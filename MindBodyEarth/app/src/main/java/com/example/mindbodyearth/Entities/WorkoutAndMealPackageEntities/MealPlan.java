package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meal_plan_table")
public class MealPlan
{
    @ColumnInfo(name = "meals")
    private List<Meal> meals;

    @ColumnInfo(name = "day")
    private String day; //there is a class for Local Date and Day, try using that -khaira

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
