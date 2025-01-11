package com.example.mindbodyearth;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

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
}