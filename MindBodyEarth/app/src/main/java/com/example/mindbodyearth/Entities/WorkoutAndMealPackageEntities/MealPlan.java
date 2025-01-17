package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "meal_plan_table")
public class MealPlan
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "meal_plan_id")
    protected final long mealPlanId;

//    @ColumnInfo(name = "meals")
//    @TypeConverters({Converters.class})
//    private List<Meal> meals;

    @ColumnInfo(name = "day")
    private String day; //there is a class for Local Date and Day, try using that -khaira

    public MealPlan(String day, List<Meal> meals) {
        this.mealPlanId = 0; // Let Room auto-generate the ID
        this.day = day;
    }

    public MealPlan(String day) {
        this.day = day;
        this.mealPlanId = 0; // Let Room auto-generate the ID
    }

//    public void setMeals(List<Meal> meals)
//    {
//        this.meals = meals;
//    }
//    public void addMeal(Meal meal)
//    {
//        meals.add(meal);
//    }
//
//    public List<Meal> getMeals()
//    {
//        return meals;
//    }

    public String getDay()
    {
        return day;
    }

    public long getMealPlanId() {
        return mealPlanId;
    }

    double getTodaysMealFootprint(String today) {
        List<MealPlanWithMeals> mealPlans = getMealPlanWithMealsByDay(today);
        double totalFootprint = 0.0;
        for (MealPlanWithMeals mealPlanWithMeals : mealPlans) {
            totalFootprint += mealPlanWithMeals.mealPlan.calculateMealPlanFootprint(mealPlanWithMeals.meals);
        }
        return totalFootprint;
    }

    private List<MealPlanWithMeals> getMealPlanWithMealsByDay(String today) {

    }


    public double calculateMealPlanFootprint(List<Meal> meals) {
    }
}
