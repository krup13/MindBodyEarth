package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insert(Food food);

    @Update
    void update(Food food);

    @Delete
    void delete(Food food);

    @Query("SELECT * FROM food")
    List<Food> getAllFoods();

    @Query("SELECT * FROM food WHERE id = :foodId")
    Food getFoodById(int foodId);
}
