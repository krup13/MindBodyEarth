package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class FoodsWithMeals {
    @Embedded
    public Food food;

    @Relation(
            parentColumn = "food_id",
            entityColumn = "meal_id",
            associateBy = @Junction(MealFoodCrossRef.class)
    )
    public List<Meal> meals;
}
