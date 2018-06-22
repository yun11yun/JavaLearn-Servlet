package com.yun11yun.service;

import com.yun11yun.bean.User;
import com.yun11yun.dao.UserDao;
import java.sql.SQLException;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean checkUser(User user) throws SQLException {
        if (user == null) {
            return false;
        }

        userDao.query(user.getName(),user.getPassword());

        return false;
    }

    public boolean checkUser(String username, String password) throws SQLException {
        if (username == null || password == null) {
            return false;
        }

        User user = userDao.query(username,password);

        if (user != null) {
            return true;
        }

        return false;
    }

    public int getUIDWith(String username, String password) throws SQLException {
        if (username == null || password == null) {
            return -1;
        }

        User user = userDao.query(username,password);

        if (user != null) {
            return user.getUid();
        } else {
            return -1;
        }
    }
}
