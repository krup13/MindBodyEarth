package com.example.mindbodyearth.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    public long id;

    public long getId() {
        return id;
    }

    //id cannot be changed

    @PrimaryKey
    @ColumnInfo(name = "email")
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ColumnInfo(name = "username")
    public String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ColumnInfo(name = "password")
    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}