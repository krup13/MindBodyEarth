package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.JunctionEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal_junction_food_table")
public class MealFood {
    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    @PrimaryKey //get from Meal.java
    @ColumnInfo(name = "meal_id")
    private long mealId;

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    @ColumnInfo(name = "food_id")
    private long foodId;

    public MealFood(long meal_id, long food_id)
    {
        this.mealId = meal_id;
    }

    public MealFood() {}
}
