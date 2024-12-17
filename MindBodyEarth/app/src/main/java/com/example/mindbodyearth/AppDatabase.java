package com.example.mindbodyearth;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mindbodyearth.Dao.UserDao;

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao;

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE==null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DbConfig.ROOM_DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
