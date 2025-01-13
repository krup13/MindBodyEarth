package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;

import java.util.List;

@Dao
public interface MealPlanDao {
    @Insert
    void insertMealPlan(MealPlan mealPlan);

    @Update
    void updateMealPlan(MealPlan mealPlan);

    @Delete
    void deleteMealPlan(MealPlan mealPlan);

    @Query("SELECT * FROM meal_plan_table")
    List<MealPlan> allMealPlans();

//    @Query("UPDATE meal_plan_table SET meal = :newMeal WHERE mealPlanId = :mealPlanId")
//    void editMealPlan(Meal newMeal, int mealPlanId);
}