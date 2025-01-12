package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

public class WorkoutPlan {
    private String workoutPlanName;
    private String workoutPlanDescription;
    private int workoutPlanDuration;

    // Constructor
    public WorkoutPlan(String workoutPlanName, String workoutPlanDescription, int workoutPlanDuration) {
        this.workoutPlanName = workoutPlanName;
        this.workoutPlanDescription = workoutPlanDescription;
        this.workoutPlanDuration = workoutPlanDuration;
    }

    // Getter for workoutPlanName
    public String getWorkoutPlanName() {
        return workoutPlanName;
    }

    // Setter for workoutPlanName
    public void setWorkoutPlanName(String workoutPlanName) {
        this.workoutPlanName = workoutPlanName;
    }

    // Getter for workoutPlanDescription
    public String getWorkoutPlanDescription() {
        return workoutPlanDescription;
    }

    // Setter for workoutPlanDescription
    public void setWorkoutPlanDescription(String workoutPlanDescription) {
        this.workoutPlanDescription = workoutPlanDescription;
    }

    // Getter for workoutPlanDuration
    public int getWorkoutPlanDuration() {
        return workoutPlanDuration;
    }

    // Setter for workoutPlanDuration
    public void setWorkoutPlanDuration(int workoutPlanDuration) {
        this.workoutPlanDuration = workoutPlanDuration;
    }
}
