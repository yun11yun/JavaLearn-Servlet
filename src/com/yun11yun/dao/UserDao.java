package com.yun11yun.dao;

import com.yun11yun.bean.User;
import com.yun11yun.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

public class UserDao {

    private DataSource dataSource;
    private QueryRunner qr;

    public UserDao() {
        dataSource = C3p0Utils.getDataSource();
        qr = new QueryRunner(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public User query(String username, String password) throws SQLException {

        if (username == null || password == null) {
            return null;
        }

        String sql = "SELECT * FROM consumer WHERE cname=? AND password=?";
        String[] parameters = {username, password};
        Map<String, Object> userMap = qr.query(sql, parameters, new MapHandler());

        if (userMap == null) {
            return null;
        }

        User user = new User(userMap);
        return user;
    }

    public User query(int uid) throws SQLException {
        if (uid <= 0) {
            return null;
        }

        String sql = "SELECT * FROM consumer WHERE cid=?";
        Map<String, Object> map = qr.query(sql, uid, new MapHandler());

        if (map == null) {
            return null;
        }

        User user = new User(map);
        return user;
    }
}
