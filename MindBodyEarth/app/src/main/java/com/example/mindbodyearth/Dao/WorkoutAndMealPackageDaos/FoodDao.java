package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import static android.icu.text.ListFormatter.Type.AND;
import static android.icu.text.MessagePattern.ArgType.SELECT;
import static android.os.Build.VERSION_CODES.M;
import static android.webkit.WebSettings.PluginState.ON;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insert(Food food);

    @Update
    void update(Food food);

    @Delete
    void delete(Food food);

    /*@Query(SELECT M.mealComposition, M.totalCalories, M.timeOfDayConsumed
            FROM meal_table M
            JOIN Food F ON F.foodName = :foodName AND F IN M.mealComposition)
    List<Meal> whatFoodInWhatMeal();*/
}
