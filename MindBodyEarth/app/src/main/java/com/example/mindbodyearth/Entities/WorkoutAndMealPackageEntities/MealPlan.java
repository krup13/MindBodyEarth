package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.util.List;

@Entity(tableName = "meal_plan_table")
public class MealPlan
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "meal_plan_id")
    protected final long mealPlanId;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "meals")
    private List<Meal> meals;

    @ColumnInfo(name = "day")
    private String day; //there is a class for Local Date and Day, try using that -khaira

    public MealPlan(String day, List<Meal> meals) {
        this.mealPlanId = 0; // Let Room auto-generate the ID
        this.day = day;
        this.meals = meals;
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

    public long getMealPlanId() {
        return mealPlanId;
    }

//    public double calculateMealFootprint() {
//
//    }
}
