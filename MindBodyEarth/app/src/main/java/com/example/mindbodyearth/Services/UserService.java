package com.example.mindbodyearth.Services;

import com.example.mindbodyearth.Dao.UserDao;
import com.example.mindbodyearth.Entities.User;

public class UserService {
    private static UserDao userDao;

    public UserService(UserDao userDao) { this.userDao = userDao;}

    public User authenticate(String email, String password) {
        User user = userDao.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void registerUser(User user) {
        userDao.insertUser(user);
    }


}
