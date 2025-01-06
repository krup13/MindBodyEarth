package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;

import java.util.ArrayList;
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

    @Query("UPDATE * FROM meal_plan_table WHERE mealPlanId = :mealPlanId")
    MealPlan editMealPlan(Meal newMeal);

    @Query(SELECT calories COUNT(*) FROM meal_table GROUP BY days = mealArrayList.equals()) // days = should be smtg else but idk whattttttt
    int calculateCaloriesConsumed(ArrayList<Meal> mealArrayList)
    //use .getCalories for each Meal object

}
