package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlanWithMeals;

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

//    @Query("UPDATE * FROM meal_plan_table WHERE mealPlanId = :mealPlanId")
//    MealPlan editMealPlan(Meal newMeal);

    @Transaction
    @Query("SELECT * FROM meal_plan_table")
    public List<MealPlanWithMeals> getMealPlanWithMeals();

    @Transaction
    @Query("SELECT * FROM meal_plan_table WHERE day = :day")
    List<MealPlanWithMeals> getMealPlanWithMealsByDay(String day);

    default double getTodaysMealFootprint(String today) {
        List<MealPlanWithMeals> mealPlans = getMealPlanWithMealsByDay(today);
        double totalFootprint = 0.0;
        for (MealPlanWithMeals mealPlanWithMeals : mealPlans) {
            totalFootprint += mealPlanWithMeals.mealPlan.calculateMealPlanFootprint(mealPlanWithMeals.meals);
        }
        return totalFootprint;
    }

}