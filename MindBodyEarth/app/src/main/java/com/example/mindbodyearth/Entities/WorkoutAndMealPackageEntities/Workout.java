package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workout_table")
public class Workout
{

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "workout_name")
    private String workoutName;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "sets")
    private int sets;

    @ColumnInfo(name = "reps")
    private int reps;
//    private boolean completionStatus;
//    private String imagePath;
//    private int imageResourceId;

    // Constructor
    public Workout(String workoutName, String type, int sets, int reps)
    {
//        this.workoutId = workoutId;
        this.workoutName = workoutName;
        this.type = type;
        this.sets = sets;
        this.reps = reps;
//        this.completionStatus = false; // Initially set to incomplete
//        this.imageResourceId = imageResourceId;
    }

//    public int getImageResourceId()
//    {
//        return imageResourceId;
//    }

//    public String getImagePath()
//    {
//        return imagePath;
//    }
//    public long getWorkoutId()
//    {
//        return workoutId;
//    }

//    public void setWorkoutId(long workoutId)
//    {
//        this.workoutId = workoutId;
//    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    public String getWorkoutName()
    {
        return workoutName;
    }

    public void setWorkoutName(String workoutName)
    {
        this.workoutName = workoutName;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getSets()
    {
        return sets;
    }

    public void setSets(int sets)
    {
        this.sets = sets;
    }

    public int getReps()
    {
        return reps;
    }

    public void setReps(int reps)
    {
        this.reps = reps;
    }

//    public boolean isCompletionStatus()
//    {
//        return completionStatus;
//    }

//    public void setCompletionStatus(boolean completionStatus)
//    {
//        this.completionStatus = completionStatus;
//    }

//    public boolean trackProgress(boolean workoutCompletionStatus)
//    {
//        this.completionStatus = workoutCompletionStatus;
//        return completionStatus;
//    }

//    public boolean completeWorkouts() {
//        // Implementation for completing workouts
//    }
}
