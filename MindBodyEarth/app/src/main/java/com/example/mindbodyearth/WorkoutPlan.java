package com.example.mindbodyearth;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan
{
    private List<Workout> workouts;

    public WorkoutPlan() {
        this.workouts = new ArrayList<>();
    }
    public void addWorkout(Workout workout){
        workouts.add(workout);
    }
    public List<Workout> getWorkouts(){return workouts;}
    // ... getters and setters
}
