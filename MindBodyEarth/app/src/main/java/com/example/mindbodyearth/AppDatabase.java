package com.example.mindbodyearth;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mindbodyearth.Dao.UserDao;
import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalDao;
import com.example.mindbodyearth.Dao.MeditationDaos.MeditationVideoDao;
import com.example.mindbodyearth.Entities.User;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal;
import com.example.mindbodyearth.Entities.Meditation.MeditationVideo;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;

@Database(entities = {
        User.class,
        Food.class, Meal.class, MealPlan.class, Workout.class, WorkoutPlan.class,
        Journal.class, MeditationVideo.class // Add new entities here
}, version = 1) // Start with version 1
public abstract class AppDatabase extends RoomDatabase {
    public com.example.mindbodyearth.Dao.UserDao UserDao;

    // DAO Methods
    public abstract UserDao userDao();
    public abstract JournalDao journalingDao();
    public abstract MeditationVideoDao meditationVideoDao();

    private static volatile AppDatabase INSTANCE;

    // Singleton Instance
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "mindbodyearth-db" // Replace with DbConfig.ROOM_DB_NAME if defined
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
