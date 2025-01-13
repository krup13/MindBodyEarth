package com.example.mindbodyearth;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Dao.UserDao;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.CarbonFootprint;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.EnergyConsumption;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Transportation;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Waste;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry;
import com.example.mindbodyearth.Entities.Meditation.MeditationArticle;
import com.example.mindbodyearth.Entities.Meditation.MeditationVideo;
import com.example.mindbodyearth.Entities.User;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.JunctionEntities.MealFood;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;

@Database(entities = {User.class, Food.class, Meal.class, MealPlan.class, Workout.class, WorkoutPlan.class,
                        MealFood.class, //junction entitiy between Meal-Food
                            CarbonFootprint.class, EnergyConsumption.class, Transportation.class, Waste.class,
                                Journal.class, JournalEntry.class,
                                    MeditationArticle.class, MeditationVideo.class}
                        , version = 1)
@TypeConverters({Converters.class})
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

    public static AppDatabase getInstance(Context context) {
    return getDatabase(context);
}

    public UserDao userDao() {
        return userDao;
    }
}
