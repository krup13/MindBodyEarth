package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;

import java.util.List;

@Dao
public interface WorkoutPlanDao {
    @Insert
    void insert(WorkoutPlan workoutPlan);

    @Update
    void update(WorkoutPlan workoutPlan);

    @Delete
    void delete(WorkoutPlan workoutPlan);

    @Query("SELECT * FROM workout_plan_table")
    List<WorkoutPlan> allWorkoutPlans();

    //@Query("SELECT * FROM workout_plan_table") <-- to get workout for tdy


}
