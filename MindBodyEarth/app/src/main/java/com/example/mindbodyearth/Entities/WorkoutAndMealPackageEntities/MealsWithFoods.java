package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class MealsWithFoods {
    @Embedded
    public Meal meal;

    @Relation(
            parentColumn = "meal_id",
            entityColumn = "food_id",
            associateBy = @Junction(MealFoodCrossRef.class)
    )
    public List<Food> foods;
}
