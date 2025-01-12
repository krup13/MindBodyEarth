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
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(0) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_table` (`email` TEXT, `username` TEXT, `password` TEXT, PRIMARY KEY(`email`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `food_table` (`food_id` INTEGER NOT NULL, `food_name` TEXT, `main_nutrient` TEXT, `calories` INTEGER NOT NULL, PRIMARY KEY(`food_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_table` (`mealPlan` TEXT, `meal_id` INTEGER NOT NULL, `meal_composition` TEXT, `total_calories` INTEGER NOT NULL, `days` TEXT, `timeOfDayConsumed` TEXT, PRIMARY KEY(`meal_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_plan_table` (`meal_plan_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `meals` TEXT, `day` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `workout_table` (`workout_id` INTEGER NOT NULL, `type` TEXT, `sets` INTEGER NOT NULL, `reps` INTEGER NOT NULL, `completion_status` INTEGER NOT NULL, PRIMARY KEY(`workout_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `workout_plan_table` (`workout_plan_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `workouts` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dbaec0eaec36c70cb8ec18fc2ad62a96')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `user_table`");
        db.execSQL("DROP TABLE IF EXISTS `food_table`");
        db.execSQL("DROP TABLE IF EXISTS `meal_table`");
        db.execSQL("DROP TABLE IF EXISTS `meal_plan_table`");
        db.execSQL("DROP TABLE IF EXISTS `workout_table`");
        db.execSQL("DROP TABLE IF EXISTS `workout_plan_table`");
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
        _columnsUserTable.put("email", new TableInfo.Column("email", "TEXT", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
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
        final HashMap<String, TableInfo.Column> _columnsFoodTable = new HashMap<String, TableInfo.Column>(4);
        _columnsFoodTable.put("food_id", new TableInfo.Column("food_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("food_name", new TableInfo.Column("food_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("main_nutrient", new TableInfo.Column("main_nutrient", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodTable.put("calories", new TableInfo.Column("calories", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFoodTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodTable = new TableInfo("food_table", _columnsFoodTable, _foreignKeysFoodTable, _indicesFoodTable);
        final TableInfo _existingFoodTable = TableInfo.read(db, "food_table");
        if (!_infoFoodTable.equals(_existingFoodTable)) {
          return new RoomOpenHelper.ValidationResult(false, "food_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food).\n"
                  + " Expected:\n" + _infoFoodTable + "\n"
                  + " Found:\n" + _existingFoodTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMealTable = new HashMap<String, TableInfo.Column>(6);
        _columnsMealTable.put("mealPlan", new TableInfo.Column("mealPlan", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        _columnsWorkoutTable.put("workout_id", new TableInfo.Column("workout_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("sets", new TableInfo.Column("sets", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("reps", new TableInfo.Column("reps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("completion_status", new TableInfo.Column("completion_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        _columnsWorkoutPlanTable.put("workouts", new TableInfo.Column("workouts", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutPlanTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutPlanTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutPlanTable = new TableInfo("workout_plan_table", _columnsWorkoutPlanTable, _foreignKeysWorkoutPlanTable, _indicesWorkoutPlanTable);
        final TableInfo _existingWorkoutPlanTable = TableInfo.read(db, "workout_plan_table");
        if (!_infoWorkoutPlanTable.equals(_existingWorkoutPlanTable)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_plan_table(com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan).\n"
                  + " Expected:\n" + _infoWorkoutPlanTable + "\n"
                  + " Found:\n" + _existingWorkoutPlanTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dbaec0eaec36c70cb8ec18fc2ad62a96", "1107d68bd9ab766c3e72b93570715dca");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_table","food_table","meal_table","meal_plan_table","workout_table","workout_plan_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `user_table`");
      _db.execSQL("DELETE FROM `food_table`");
      _db.execSQL("DELETE FROM `meal_table`");
      _db.execSQL("DELETE FROM `meal_plan_table`");
      _db.execSQL("DELETE FROM `workout_table`");
      _db.execSQL("DELETE FROM `workout_plan_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
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
