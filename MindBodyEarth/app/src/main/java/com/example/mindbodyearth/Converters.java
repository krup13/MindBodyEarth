package com.example.mindbodyearth;

import androidx.room.TypeConverter;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//used for listed attributes to be stored in database
public class Converters
{
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


    //Converter for ArrayList to String
    @TypeConverter
    public static String arrayListToString(ArrayList<?> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static ArrayList<?> stringToArrayList(String data) {
        if (data == null) {
            return new ArrayList<>();
        }

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<?>>() {}.getType();
        return gson.fromJson(data, type);
    }


    //Converter for List to String
    @TypeConverter
    public static String listToString(List<?> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<?> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<?>>() {}.getType();
        return gson.fromJson(data, type);
    }
}