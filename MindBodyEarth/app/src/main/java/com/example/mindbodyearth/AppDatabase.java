package com.example.mindbodyearth;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao.CarbonFootprintDao;
import com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao.EnergyConsumptionDao;
import com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao.TransportationDao;
import com.example.mindbodyearth.Dao.CarbonFootprintTrackerPackageDao.WasteDao;
import com.example.mindbodyearth.Dao.HealthTrackingPackageDaos.HealthDataDao;
import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalDao;
import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalEntryDao;
import com.example.mindbodyearth.Dao.MeditationDaos.MeditationArticleDao;
import com.example.mindbodyearth.Dao.MeditationDaos.MeditationVideoDao;
import com.example.mindbodyearth.Dao.UserDao;
import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.FoodDao;
import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.MealDao;
import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.MealPlanDao;
import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.WorkoutDao;
import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.WorkoutPlanDao;
import com.example.mindbodyearth.Entities.HealthTrackerPackageEntities.HealthData;import com.example.mindbodyearth.Entities.HealthTrackerPackageEntities.HealthData;
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
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;

@Database(entities = {User.class, Food.class, Meal.class, MealPlan.class, Workout.class, WorkoutPlan.class,
                        CarbonFootprint.class, EnergyConsumption.class, Transportation.class, Waste.class,
                            Journal.class, JournalEntry.class,
                               MeditationArticle.class, MeditationVideo.class,
                                  HealthData.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FoodDao foodDao();
    public abstract MealDao mealDao();
    public abstract MealPlanDao mealPlanDao();
    public abstract WorkoutDao workoutDao();
    public abstract WorkoutPlanDao workoutPlanDao();
    public abstract CarbonFootprintDao carbonFootprintDao();
    public abstract EnergyConsumptionDao energyConsumptionDao();
    public abstract TransportationDao transportationDao();
    public abstract WasteDao wasteDao();
    public abstract JournalDao journalDao();
    public abstract JournalEntryDao journalEntryDao();
    public abstract MeditationArticleDao meditationArticleDao();
    public abstract MeditationVideoDao meditationVideoDao();
    public abstract HealthDataDao healthDataDao();


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

}
