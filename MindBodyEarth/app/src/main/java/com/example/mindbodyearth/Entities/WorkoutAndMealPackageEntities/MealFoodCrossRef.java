package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.Entity;

import com.example.mindbodyearth.DbConfig;

//associate entity for Meal & Food cuz 1..* Meal - 1..* Food
@Entity(tableName = DbConfig.MEAL_FOOD_CROSS_REF_TABLE, primaryKeys = {"meal_id", "food_id"})
public class MealFoodCrossRef {
    public long meal_id;
    public long food_id;
}
