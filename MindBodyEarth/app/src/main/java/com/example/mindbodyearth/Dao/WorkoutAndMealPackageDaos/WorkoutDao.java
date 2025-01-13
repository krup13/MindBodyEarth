package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;

import java.util.List;
@Dao
public interface WorkoutDao {
    @Insert
    void insertWorkout(Workout workout);

    @Update
    void updateWorkout(Workout workout);

    @Delete
    void deleteWorkout(Workout workout);

    @Query("SELECT * FROM workout_table")
    List<Workout> getAllWorkouts();

    @Query("SELECT * FROM workout_table WHERE workout_id = :id")
    Workout getWorkoutById(int id);

    @Query("SELECT * FROM workout_table WHERE workout_name = :workoutName")
    Workout getWorkoutByName(String workoutName);

    @Query("SELECT * FROM workout_table WHERE duration < :maxDuration")
    List<Workout> getWorkoutsUnderDuration(int maxDuration);

    @Query("SELECT * FROM workout_table WHERE intensity = :intensity")
    List<Workout> getWorkoutsByIntensity(String intensity);
}
