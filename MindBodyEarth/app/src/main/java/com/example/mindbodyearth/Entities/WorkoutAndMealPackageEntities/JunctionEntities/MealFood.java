package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.JunctionEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal_junction_food_table")
public class MealFood {
    @PrimaryKey //get from Meal.java
    @ColumnInfo(name = "meal_id")
    private long mealId;

    @ColumnInfo(name = "food_id")
    private long foodId;

    public MealFood(long meal_id, long food_id)
    {
        this.mealId = meal_id;
    }
}
