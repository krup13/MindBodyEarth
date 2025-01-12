package com.example.mindbodyearth;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.FoodDao;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;

@Database(entities = {Food.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();
}
