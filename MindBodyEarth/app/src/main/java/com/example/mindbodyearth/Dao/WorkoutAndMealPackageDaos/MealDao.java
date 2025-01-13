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

//    @Query("UPDATE meal_table SET meal_composition = :newComposition WHERE meal_id = :mealId FROM meal_table")
//    List<Meal> newMealList();

    @Query("SELECT * FROM meal_table")
    List<Meal> allMeals();

    //add food to meal
//    @Query("UPDATE meal_table SET mealComposition = :newMealComposition WHERE meal_plan_id = :mealPlanId")
//    void editMealComposition(Food newFood);

    //editing the mealCompostition
//    @Insert(onConflict = OnConflictStrategy.REPLACE) // Replace if entry exists
//    void addFoodToMeal(MealFood mealFood);

    @Query("DELETE * FROM meal_food WHERE meal_id = :mealPlanId AND food_id = :foodId")
    void removeFoodFromMeal(long mealPlanId, long foodId);

    @Query("SELECT * FROM meal_table")
    List<Meal> getAllMeals();

    @Query("SELECT * FROM meal_table WHERE meal_id = :id")
    Meal getMealById(int id);

    @Query("SELECT * FROM meal_table WHERE meal_name = :mealName")
    Meal getMealByName(String mealName);

    @Query("SELECT * FROM meal_table WHERE total_calories < :maxCalories")
    List<Meal> getMealsUnderCalories(int maxCalories);

    @Query("SELECT * FROM meal_table WHERE time_of_day_consumed = :timeOfDay")
    List<Meal> getMealsByTimeOfDay(String timeOfDay);
}
