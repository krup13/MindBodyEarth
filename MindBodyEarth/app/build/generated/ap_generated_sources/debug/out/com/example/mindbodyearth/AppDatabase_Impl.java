package com.example.mindbodyearth;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_table` (`email` TEXT NOT NULL, `username` TEXT, `password` TEXT, PRIMARY KEY(`email`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `food_table` (`food_id` INTEGER NOT NULL, `food_name` TEXT, `main_nutrient` TEXT, `calories` INTEGER NOT NULL, `carbon_footprint` REAL NOT NULL, PRIMARY KEY(`food_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_table` (`meal_id` INTEGER NOT NULL, `meal_composition` TEXT, `total_calories` INTEGER NOT NULL, `days` TEXT, `timeOfDayConsumed` TEXT, PRIMARY KEY(`meal_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_plan_table` (`meal_plan_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `meals` TEXT, `day` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `workout_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `workout_name` TEXT NOT NULL, `type` TEXT, `sets` INTEGER NOT NULL, `reps` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `workout_plan_table` (`workout_plan_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `my_list` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_junction_food_table` (`meal_id` INTEGER NOT NULL, `food_id` INTEGER NOT NULL, PRIMARY KEY(`meal_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `carbon_footprint_table` (`date` INTEGER NOT NULL, `total_footprint` REAL NOT NULL, `energy_footprint` REAL NOT NULL, `transportation_footprint` REAL NOT NULL, `meal_footprint` REAL NOT NULL, `waste_footprint` REAL NOT NULL, PRIMARY KEY(`date`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `energy_consumption_table` (`date` INTEGER NOT NULL, `electricity_usage` REAL NOT NULL, `gas_usage` REAL NOT NULL, PRIMARY KEY(`date`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `transportation_table` (`date` INTEGER NOT NULL, `mode_of_transportation` TEXT, `distance_travelled` REAL NOT NULL, `fuel_efficiency` REAL NOT NULL, PRIMARY KEY(`date`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `waste_table` (`date` INTEGER NOT NULL, `waste_generated` REAL NOT NULL, `recycling_rate` REAL NOT NULL, PRIMARY KEY(`date`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `journal_table` (`year` TEXT NOT NULL, `entries` TEXT, PRIMARY KEY(`year`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `journal_entry_table` (`journalId` INTEGER, `journalYear` INTEGER NOT NULL, `day` TEXT, `date` TEXT, `title` TEXT, `content` TEXT, PRIMARY KEY(`journalId`), FOREIGN KEY(`journalYear`) REFERENCES `journal_table`(`year`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meditation_articles` (`article_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `article_link` TEXT, `favorites` INTEGER NOT NULL, `title` TEXT, `bookmarks` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meditation_video_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `youtube_link` TEXT, `favorites` INTEGER NOT NULL, `title` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '18df8639f71fd7bd33e3cb1700fafbc0')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `user_table`");
        db.execSQL("DROP TABLE IF EXISTS `food_table`");
        db.execSQL("DROP TABLE IF EXISTS `meal_table`");
        db.execSQL("DROP TABLE IF EXISTS `meal_plan_table`");
        db.execSQL("DROP TABLE IF EXISTS `workout_table`");
        db.execSQL("DROP TABLE IF EXISTS `workout_plan_table`");
        db.execSQL("DROP TABLE IF EXISTS `meal_junction_food_table`");
        db.execSQL("DROP TABLE IF EXISTS `carbon_footprint_table`");
        db.execSQL("DROP TABLE IF EXISTS `energy_consumption_table`");
        db.execSQL("DROP TABLE IF EXISTS `transportation_table`");
        db.execSQL("DROP TABLE IF EXISTS `waste_table`");
        db.execSQL("DROP TABLE IF EXISTS `journal_table`");
        db.execSQL("DROP TABLE IF EXISTS `journal_entry_table`");
        db.execSQL("DROP TABLE IF EXISTS `meditation_articles`");
        db.execSQL("DROP TABLE IF EXISTS `meditation_video_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUserTable = new HashMap<String, TableInfo.Column>(3);
        _columnsUserTable.put("email", new TableInfo.Column("email", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserTable = new TableInfo("user_table", _columnsUserTable, _foreignKeysUserTable, _indicesUserTable);
        final TableInfo _existingUserTable = TableInfo.read(db, "user_table");
        if (!_infoUserTable.equals(_existingUserTable)) {
          return new RoomOpenHelper.ValidationResult(false, "user_table(com.example.mindbodyearth.Entities.User).\n"
                  + " Expected:\n" + _infoUserTable + "\n"
                  + " Found:\n" + _existingUserTable);
        }
        final HashMap<String, TableInfo.Column> _columnsFoodTable = new HashMap<String, TableInfo.Column>(5);
        _columnsFoodTable.put("food_id", new TableInfo.Column("food_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("food_name", new TableInfo.Column("food_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("main_nutrient", new TableInfo.Column("main_nutrient", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("calories", new TableInfo.Column("calories", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("carbon_footprint", new TableInfo.Column("carbon_footprint", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFoodTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodTable = new TableInfo("food_table", _columnsFoodTable, _foreignKeysFoodTable, _indicesFoodTable);
        final TableInfo _existingFoodTable = TableInfo.read(db, "food_table");
        if (!_infoFoodTable.equals(_existingFoodTable)) {
          return new RoomOpenHelper.ValidationResult(false, "food_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food).\n"
                  + " Expected:\n" + _infoFoodTable + "\n"
                  + " Found:\n" + _existingFoodTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMealTable = new HashMap<String, TableInfo.Column>(5);
        _columnsMealTable.put("meal_id", new TableInfo.Column("meal_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealTable.put("meal_composition", new TableInfo.Column("meal_composition", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealTable.put("total_calories", new TableInfo.Column("total_calories", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealTable.put("days", new TableInfo.Column("days", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealTable.put("timeOfDayConsumed", new TableInfo.Column("timeOfDayConsumed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMealTable = new TableInfo("meal_table", _columnsMealTable, _foreignKeysMealTable, _indicesMealTable);
        final TableInfo _existingMealTable = TableInfo.read(db, "meal_table");
        if (!_infoMealTable.equals(_existingMealTable)) {
          return new RoomOpenHelper.ValidationResult(false, "meal_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal).\n"
                  + " Expected:\n" + _infoMealTable + "\n"
                  + " Found:\n" + _existingMealTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMealPlanTable = new HashMap<String, TableInfo.Column>(3);
        _columnsMealPlanTable.put("meal_plan_id", new TableInfo.Column("meal_plan_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealPlanTable.put("meals", new TableInfo.Column("meals", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealPlanTable.put("day", new TableInfo.Column("day", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealPlanTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealPlanTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMealPlanTable = new TableInfo("meal_plan_table", _columnsMealPlanTable, _foreignKeysMealPlanTable, _indicesMealPlanTable);
        final TableInfo _existingMealPlanTable = TableInfo.read(db, "meal_plan_table");
        if (!_infoMealPlanTable.equals(_existingMealPlanTable)) {
          return new RoomOpenHelper.ValidationResult(false, "meal_plan_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan).\n"
                  + " Expected:\n" + _infoMealPlanTable + "\n"
                  + " Found:\n" + _existingMealPlanTable);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkoutTable = new HashMap<String, TableInfo.Column>(5);
        _columnsWorkoutTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("workout_name", new TableInfo.Column("workout_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("sets", new TableInfo.Column("sets", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("reps", new TableInfo.Column("reps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutTable = new TableInfo("workout_table", _columnsWorkoutTable, _foreignKeysWorkoutTable, _indicesWorkoutTable);
        final TableInfo _existingWorkoutTable = TableInfo.read(db, "workout_table");
        if (!_infoWorkoutTable.equals(_existingWorkoutTable)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout).\n"
                  + " Expected:\n" + _infoWorkoutTable + "\n"
                  + " Found:\n" + _existingWorkoutTable);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkoutPlanTable = new HashMap<String, TableInfo.Column>(2);
        _columnsWorkoutPlanTable.put("workout_plan_id", new TableInfo.Column("workout_plan_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutPlanTable.put("my_list", new TableInfo.Column("my_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutPlanTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutPlanTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutPlanTable = new TableInfo("workout_plan_table", _columnsWorkoutPlanTable, _foreignKeysWorkoutPlanTable, _indicesWorkoutPlanTable);
        final TableInfo _existingWorkoutPlanTable = TableInfo.read(db, "workout_plan_table");
        if (!_infoWorkoutPlanTable.equals(_existingWorkoutPlanTable)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_plan_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan).\n"
                  + " Expected:\n" + _infoWorkoutPlanTable + "\n"
                  + " Found:\n" + _existingWorkoutPlanTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMealJunctionFoodTable = new HashMap<String, TableInfo.Column>(2);
        _columnsMealJunctionFoodTable.put("meal_id", new TableInfo.Column("meal_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealJunctionFoodTable.put("food_id", new TableInfo.Column("food_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealJunctionFoodTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealJunctionFoodTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMealJunctionFoodTable = new TableInfo("meal_junction_food_table", _columnsMealJunctionFoodTable, _foreignKeysMealJunctionFoodTable, _indicesMealJunctionFoodTable);
        final TableInfo _existingMealJunctionFoodTable = TableInfo.read(db, "meal_junction_food_table");
        if (!_infoMealJunctionFoodTable.equals(_existingMealJunctionFoodTable)) {
          return new RoomOpenHelper.ValidationResult(false, "meal_junction_food_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.JunctionEntities.MealFood).\n"
                  + " Expected:\n" + _infoMealJunctionFoodTable + "\n"
                  + " Found:\n" + _existingMealJunctionFoodTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCarbonFootprintTable = new HashMap<String, TableInfo.Column>(6);
        _columnsCarbonFootprintTable.put("date", new TableInfo.Column("date", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarbonFootprintTable.put("total_footprint", new TableInfo.Column("total_footprint", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarbonFootprintTable.put("energy_footprint", new TableInfo.Column("energy_footprint", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarbonFootprintTable.put("transportation_footprint", new TableInfo.Column("transportation_footprint", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarbonFootprintTable.put("meal_footprint", new TableInfo.Column("meal_footprint", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarbonFootprintTable.put("waste_footprint", new TableInfo.Column("waste_footprint", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCarbonFootprintTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCarbonFootprintTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCarbonFootprintTable = new TableInfo("carbon_footprint_table", _columnsCarbonFootprintTable, _foreignKeysCarbonFootprintTable, _indicesCarbonFootprintTable);
        final TableInfo _existingCarbonFootprintTable = TableInfo.read(db, "carbon_footprint_table");
        if (!_infoCarbonFootprintTable.equals(_existingCarbonFootprintTable)) {
          return new RoomOpenHelper.ValidationResult(false, "carbon_footprint_table(com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.CarbonFootprint).\n"
                  + " Expected:\n" + _infoCarbonFootprintTable + "\n"
                  + " Found:\n" + _existingCarbonFootprintTable);
        }
        final HashMap<String, TableInfo.Column> _columnsEnergyConsumptionTable = new HashMap<String, TableInfo.Column>(3);
        _columnsEnergyConsumptionTable.put("date", new TableInfo.Column("date", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnergyConsumptionTable.put("electricity_usage", new TableInfo.Column("electricity_usage", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnergyConsumptionTable.put("gas_usage", new TableInfo.Column("gas_usage", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEnergyConsumptionTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEnergyConsumptionTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEnergyConsumptionTable = new TableInfo("energy_consumption_table", _columnsEnergyConsumptionTable, _foreignKeysEnergyConsumptionTable, _indicesEnergyConsumptionTable);
        final TableInfo _existingEnergyConsumptionTable = TableInfo.read(db, "energy_consumption_table");
        if (!_infoEnergyConsumptionTable.equals(_existingEnergyConsumptionTable)) {
          return new RoomOpenHelper.ValidationResult(false, "energy_consumption_table(com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.EnergyConsumption).\n"
                  + " Expected:\n" + _infoEnergyConsumptionTable + "\n"
                  + " Found:\n" + _existingEnergyConsumptionTable);
        }
        final HashMap<String, TableInfo.Column> _columnsTransportationTable = new HashMap<String, TableInfo.Column>(4);
        _columnsTransportationTable.put("date", new TableInfo.Column("date", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransportationTable.put("mode_of_transportation", new TableInfo.Column("mode_of_transportation", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransportationTable.put("distance_travelled", new TableInfo.Column("distance_travelled", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransportationTable.put("fuel_efficiency", new TableInfo.Column("fuel_efficiency", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransportationTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTransportationTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransportationTable = new TableInfo("transportation_table", _columnsTransportationTable, _foreignKeysTransportationTable, _indicesTransportationTable);
        final TableInfo _existingTransportationTable = TableInfo.read(db, "transportation_table");
        if (!_infoTransportationTable.equals(_existingTransportationTable)) {
          return new RoomOpenHelper.ValidationResult(false, "transportation_table(com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Transportation).\n"
                  + " Expected:\n" + _infoTransportationTable + "\n"
                  + " Found:\n" + _existingTransportationTable);
        }
        final HashMap<String, TableInfo.Column> _columnsWasteTable = new HashMap<String, TableInfo.Column>(3);
        _columnsWasteTable.put("date", new TableInfo.Column("date", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWasteTable.put("waste_generated", new TableInfo.Column("waste_generated", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWasteTable.put("recycling_rate", new TableInfo.Column("recycling_rate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWasteTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWasteTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWasteTable = new TableInfo("waste_table", _columnsWasteTable, _foreignKeysWasteTable, _indicesWasteTable);
        final TableInfo _existingWasteTable = TableInfo.read(db, "waste_table");
        if (!_infoWasteTable.equals(_existingWasteTable)) {
          return new RoomOpenHelper.ValidationResult(false, "waste_table(com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Waste).\n"
                  + " Expected:\n" + _infoWasteTable + "\n"
                  + " Found:\n" + _existingWasteTable);
        }
        final HashMap<String, TableInfo.Column> _columnsJournalTable = new HashMap<String, TableInfo.Column>(2);
        _columnsJournalTable.put("year", new TableInfo.Column("year", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournalTable.put("entries", new TableInfo.Column("entries", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysJournalTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesJournalTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJournalTable = new TableInfo("journal_table", _columnsJournalTable, _foreignKeysJournalTable, _indicesJournalTable);
        final TableInfo _existingJournalTable = TableInfo.read(db, "journal_table");
        if (!_infoJournalTable.equals(_existingJournalTable)) {
          return new RoomOpenHelper.ValidationResult(false, "journal_table(com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal).\n"
                  + " Expected:\n" + _infoJournalTable + "\n"
                  + " Found:\n" + _existingJournalTable);
        }
        final HashMap<String, TableInfo.Column> _columnsJournalEntryTable = new HashMap<String, TableInfo.Column>(6);
        _columnsJournalEntryTable.put("journalId", new TableInfo.Column("journalId", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournalEntryTable.put("journalYear", new TableInfo.Column("journalYear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournalEntryTable.put("day", new TableInfo.Column("day", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournalEntryTable.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournalEntryTable.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournalEntryTable.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysJournalEntryTable = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysJournalEntryTable.add(new TableInfo.ForeignKey("journal_table", "CASCADE", "NO ACTION", Arrays.asList("journalYear"), Arrays.asList("year")));
        final HashSet<TableInfo.Index> _indicesJournalEntryTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJournalEntryTable = new TableInfo("journal_entry_table", _columnsJournalEntryTable, _foreignKeysJournalEntryTable, _indicesJournalEntryTable);
        final TableInfo _existingJournalEntryTable = TableInfo.read(db, "journal_entry_table");
        if (!_infoJournalEntryTable.equals(_existingJournalEntryTable)) {
          return new RoomOpenHelper.ValidationResult(false, "journal_entry_table(com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry).\n"
                  + " Expected:\n" + _infoJournalEntryTable + "\n"
                  + " Found:\n" + _existingJournalEntryTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMeditationArticles = new HashMap<String, TableInfo.Column>(5);
        _columnsMeditationArticles.put("article_id", new TableInfo.Column("article_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationArticles.put("article_link", new TableInfo.Column("article_link", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationArticles.put("favorites", new TableInfo.Column("favorites", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationArticles.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationArticles.put("bookmarks", new TableInfo.Column("bookmarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeditationArticles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeditationArticles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeditationArticles = new TableInfo("meditation_articles", _columnsMeditationArticles, _foreignKeysMeditationArticles, _indicesMeditationArticles);
        final TableInfo _existingMeditationArticles = TableInfo.read(db, "meditation_articles");
        if (!_infoMeditationArticles.equals(_existingMeditationArticles)) {
          return new RoomOpenHelper.ValidationResult(false, "meditation_articles(com.example.mindbodyearth.Entities.Meditation.MeditationArticle).\n"
                  + " Expected:\n" + _infoMeditationArticles + "\n"
                  + " Found:\n" + _existingMeditationArticles);
        }
        final HashMap<String, TableInfo.Column> _columnsMeditationVideoTable = new HashMap<String, TableInfo.Column>(4);
        _columnsMeditationVideoTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationVideoTable.put("youtube_link", new TableInfo.Column("youtube_link", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationVideoTable.put("favorites", new TableInfo.Column("favorites", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeditationVideoTable.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeditationVideoTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeditationVideoTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeditationVideoTable = new TableInfo("meditation_video_table", _columnsMeditationVideoTable, _foreignKeysMeditationVideoTable, _indicesMeditationVideoTable);
        final TableInfo _existingMeditationVideoTable = TableInfo.read(db, "meditation_video_table");
        if (!_infoMeditationVideoTable.equals(_existingMeditationVideoTable)) {
          return new RoomOpenHelper.ValidationResult(false, "meditation_video_table(com.example.mindbodyearth.Entities.Meditation.MeditationVideo).\n"
                  + " Expected:\n" + _infoMeditationVideoTable + "\n"
                  + " Found:\n" + _existingMeditationVideoTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "18df8639f71fd7bd33e3cb1700fafbc0", "675495b594581e62aa4f2e8ef44d5a24");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_table","food_table","meal_table","meal_plan_table","workout_table","workout_plan_table","meal_junction_food_table","carbon_footprint_table","energy_consumption_table","transportation_table","waste_table","journal_table","journal_entry_table","meditation_articles","meditation_video_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `user_table`");
      _db.execSQL("DELETE FROM `food_table`");
      _db.execSQL("DELETE FROM `meal_table`");
      _db.execSQL("DELETE FROM `meal_plan_table`");
      _db.execSQL("DELETE FROM `workout_table`");
      _db.execSQL("DELETE FROM `workout_plan_table`");
      _db.execSQL("DELETE FROM `meal_junction_food_table`");
      _db.execSQL("DELETE FROM `carbon_footprint_table`");
      _db.execSQL("DELETE FROM `energy_consumption_table`");
      _db.execSQL("DELETE FROM `transportation_table`");
      _db.execSQL("DELETE FROM `waste_table`");
      _db.execSQL("DELETE FROM `journal_table`");
      _db.execSQL("DELETE FROM `journal_entry_table`");
      _db.execSQL("DELETE FROM `meditation_articles`");
      _db.execSQL("DELETE FROM `meditation_video_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }
}
