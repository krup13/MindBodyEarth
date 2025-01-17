package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class MealPlanWithMeals {
    @Embedded
    public MealPlan mealPlan;
    @Relation(
            parentColumn = "meal_plan_id",
            entityColumn = "meal_id"
    )
    public List<Meal> meals;
}
