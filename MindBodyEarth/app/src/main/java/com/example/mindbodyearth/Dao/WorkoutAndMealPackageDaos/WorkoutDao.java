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

    @Query("SELECT * FROM workout_table WHERE workout_id = :workoutId")
     Workout getWorkoutByName(long workoutId); //make sure workoutId is autogenerated

    @Query("SELECT * FROM workout_table")
    List<Workout> getAllWorkout();

    @Query("SELECT * FROM workout_table WHERE completion_status = false")
    List<Workout> getIncompleteWorkouts();

    @Query("SELECT * FROM workout_table WHERE type = :type")
    List<Workout> getCertainTypeOfWorkouts();


}
