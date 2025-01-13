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
    void insertFood(Food food);

    @Update
    void updateFood(Food food);

    @Delete
    void deleteFood(Food food);

    @Query("SELECT * FROM food_table")
    List<Food> getAllFoods();

    @Query("SELECT * FROM food_table WHERE food_id = :id")
    Food getFoodById(int id);

    @Query("SELECT * FROM food_table WHERE food_name = :foodName")
    Food getFoodByName(String foodName);

    @Query("SELECT calories FROM food_table WHERE food_name = :foodName")
    int getCalories(String foodName);

    @Query("SELECT * FROM food_table WHERE calories < :maxCalories")
    List<Food> getFoodsUnderCalories(int maxCalories);
}
