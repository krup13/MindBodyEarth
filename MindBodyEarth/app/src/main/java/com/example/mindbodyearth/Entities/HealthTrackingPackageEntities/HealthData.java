package com.example.mindbodyearth.Entities.HealthTrackerPackageEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbodyearth.Converters;

import java.util.Date;

@Entity(tableName = "health_data_table")
public class HealthData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @TypeConverters({Converters.class})
    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "blood_pressure")
    private String bloodPressure;

    @ColumnInfo(name = "heart_rate")
    private int heartRate;

    @ColumnInfo(name = "weight")
    private double weight;

    // Constructor
    public HealthData(@NonNull Date date, String bloodPressure, int heartRate, double weight) {
        this.date = date;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.weight = weight;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}