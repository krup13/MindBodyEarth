package com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlanWithWorkouts;

import java.util.List;

@Dao
public interface WorkoutPlanDao {
    @Insert
    void insertWorkoutPlan(WorkoutPlan workoutPlan);

    @Update
    void updateWorkoutPlan(WorkoutPlan workoutPlan);

    @Delete
    void deleteWorkoutPlan(WorkoutPlan workoutPlan);

    @Query("SELECT * FROM workout_plan_table")
    List<WorkoutPlan> allWorkoutPlans();

    @Transaction
    @Query("SELECT * FROM workout_plan_table")
    public List<WorkoutPlanWithWorkouts> getWorkoutPlansWithWorkouts();



}
