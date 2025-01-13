package com.example.mindbodyearth.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mindbodyearth.Entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM user_table WHERE email = :userEmail") //user must login using email
    User getUserByEmail(String userEmail);

    @Query("SELECT * FROM user_table")
    List<User> getAllUsers();
}
