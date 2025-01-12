package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan
{

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