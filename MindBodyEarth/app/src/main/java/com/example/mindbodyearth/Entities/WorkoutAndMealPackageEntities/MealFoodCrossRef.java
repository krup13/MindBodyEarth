package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.Entity;

//associate entity for Meal & Food cuz 1..* Meal - 1..* Food
@Entity(tableName = "meal_food_cross_ref", primaryKeys = {"meal_id", "food_id"})
public class MealFoodCrossRef {
    public long meal_id;
    public long food_id;
}
