package com.example.mindbodyearth;

import androidx.room.TypeConverter;

//import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//used for listed attributes to be stored in database
public class Converters {
    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static ArrayList<String> toArrayList(String value) {
        Gson gson = new Gson();
        Type type = new com.google.gson.reflect.TypeToken<ArrayList<String>>() {
        }.getType();
        return gson.fromJson(value, type);
    }

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static String fromDateToString(Date date) {
        return date == null ? null : date.toString();
    }

    @TypeConverter
    public static String listToString(List<Workout> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<Workout> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<Workout>>() {}.getType();
        return gson.fromJson(data, type);
    }
}