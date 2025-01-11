package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "workout_plan_table")
public class WorkoutPlan
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "workout_plan_id")
    private long workoutPlanId;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "workouts")
    private List<Workout> workouts;

    public WorkoutPlan() {
        this.workouts = new ArrayList<Workout>();
    }
    public void addWorkout(Workout workout){
        workouts.add(workout);
    }
    public List<Workout> getWorkouts(){return workouts;}

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

//    @Query("SELECT * FROM workout_table WHERE completion_status = true")
//    public <Workout> getCompletedWorkouts();
//
//    @Query("SELECT * FROM workout_table WHERE completion_status = false")
//    public List<Workout> getIncompleteWorkouts();
    //need
    //convert arraylist into
}
