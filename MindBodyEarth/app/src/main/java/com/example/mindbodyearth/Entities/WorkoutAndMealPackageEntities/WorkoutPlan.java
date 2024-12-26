package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "workout_plan_table")
public class WorkoutPlan
{
    @ColumnInfo(name = "workouts")
    private List<Workout> workouts;

    public WorkoutPlan() {
        this.workouts = new ArrayList<>();
    }
    public void addWorkout(Workout workout){
        workouts.add(workout);
    }
    public List<Workout> getWorkouts(){return workouts;}

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
