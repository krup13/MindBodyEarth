package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
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

    @Transaction
    @Query("SELECT * FROM food_table")
    public List<Meal> getFoodsWithMeals();

}
