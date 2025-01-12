package com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workout_table")
public class Workout
{
    @PrimaryKey
    @ColumnInfo(name = "workout_id")
    private long workoutId;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "sets")
    private int sets;

    @ColumnInfo(name = "reps")
    private int reps;

    @ColumnInfo(name = "completion_status")
    private boolean completionStatus;

    public Workout(String type, int sets, int reps)
    {
        this.type = type;
        this. sets = sets;
        this.reps = reps;
        this.completionStatus = false;
    }

    public void setCompletionStatus(boolean completionStatus)
    {
        this.completionStatus = completionStatus;
    }

    public boolean getCompletionStatus()
    {
        return completionStatus;
    }

    public long getWorkoutId() { return workoutId; }

    public String getType()
    {
        return type;
    } //push pull legs

    public int getReps()
    {
        return reps;
    }

    public int getSets()
    {
        return sets;
    }
}
