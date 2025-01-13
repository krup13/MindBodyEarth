//package com.example.mindbodyearth;
//
//import androidx.room.TypeConverter;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.lang.reflect.Type;
//import java.util.Collections;
//import java.util.List;
//
//public class ListTypeConverter {
//
//    @TypeConverter
//    public static String listToString(List<?> list) {
//        Gson gson = new Gson();
//        return gson.toJson(list);
//    }
//
//    @TypeConverter
//    public static List<?> stringToList(String data) {
//        if (data == null) {
//            return Collections.emptyList();
//        }
//
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<?>>() {}.getType();
//        return gson.fromJson(data, type);
//    }
//}