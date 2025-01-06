package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;

import java.util.List;

@Dao
public interface MealDao {
    @Insert
    void insertMeal(Meal meal);

    @Update
    void updateMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);

    @Query("UPDATE mealComposition FROM meal_table")
    List<Meal> newMealList();

    @Query("SELECT * FROM meal_table")
    List<Meal> allMeals();
}
