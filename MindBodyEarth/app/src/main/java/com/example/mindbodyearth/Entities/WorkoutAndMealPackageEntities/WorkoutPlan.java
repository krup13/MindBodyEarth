package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "workout_plan_table")
public class WorkoutPlan
{
    @NonNull
    @ColumnInfo(name = "workout_plan_id")
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "my_list")
    @TypeConverters({Converters.class})
    private List<Workout> workoutRoutine;

    // Getters and Setters
    public List<Workout> getWorkoutRoutine()
    {
        return workoutRoutine;
    }

    public void setWorkoutRoutine(List<Workout> workoutRoutine)
    {
        this.workoutRoutine = workoutRoutine;
    }

    // Constructor
    public WorkoutPlan()
    {
        this.workoutRoutine = new ArrayList<>();
    }

    // Add a new workout to the plan
    public void addWorkout(Workout newWorkout)
    {
        workoutRoutine.add(newWorkout);
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    // Track progress for a workout
//    public boolean trackProgress(boolean workoutCompletionStatus, int workoutIndex)
//    {
//        if (workoutIndex >= 0 && workoutIndex < workoutRoutine.size())
//        {
//            workoutRoutine.get(workoutIndex).setCompletionStatus(workoutCompletionStatus);
//            return true;
//        }
//        else
//        {
//            return false; // Invalid workout index
//        }
//    }

    // Check if all workouts in the plan are completed
//    public boolean completeWorkouts()
//    {
//        for (Workout workout : workoutRoutine)
//        {
//            if (!workout.isCompletionStatus())
//            {
//                return false;
//            }
//        }
//        return true;
//    }
}