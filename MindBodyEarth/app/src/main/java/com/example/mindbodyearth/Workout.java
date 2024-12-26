package com.example.mindbodyearth;

public class Workout
{
    private String type;
    private int sets;
    private int reps;
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

    public String getType()
    {
        return type;
    }

    public int getReps()
    {
        return reps;
    }

    public int getSets()
    {
        return sets;
    }
}
