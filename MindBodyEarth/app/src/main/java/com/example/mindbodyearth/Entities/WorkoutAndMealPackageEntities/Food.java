package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String foodName;
    private int calories;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }
}
