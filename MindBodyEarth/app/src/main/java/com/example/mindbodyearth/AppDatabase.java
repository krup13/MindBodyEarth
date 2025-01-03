package com.example.mindbodyearth;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mindbodyearth.Dao.UserDao;
import com.example.mindbodyearth.Entities.User;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;

@Database(entities = {User.class, Food.class, Meal.class, MealPlan.class, Workout.class, WorkoutPlan.class
                        }
                        , version = 0)
public abstract class AppDatabase extends RoomDatabase {
    public UserDao userDao;

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE==null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DbConfig.ROOM_DB_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

}
