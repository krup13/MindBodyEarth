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
    void insert(Meal meal);

    @Update
    void update(Meal meal);

    @Delete
    void delete(Meal meal);

//    @Query("UPDATE meal_table SET meal_composition = :newComposition WHERE meal_id = :mealId FROM meal_table")
//    List<Meal> newMealList();

    @Query("SELECT * FROM meal_table")
    List<Meal> allMeals();
}
