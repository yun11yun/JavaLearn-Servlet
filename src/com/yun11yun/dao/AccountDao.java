package com.yun11yun.dao;

import com.yun11yun.bean.User;
import com.yun11yun.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

public class AccountDao {
    private DataSource dataSource;

    public AccountDao() {
        this.dataSource = C3p0Utils.getDataSource();
    }

    public User query(String username, String password) throws SQLException {
        if (username == null || password == null) {
            return null;
        }

        String sql = "SELECT * FROM consumer WHERE cname=? AND password=?";
        QueryRunner qr = new QueryRunner(this.dataSource);
        Map<String, Object> map = qr.query(sql, new MapHandler(), username, password);

        if (map == null) {
            return null;
        }

        User user = new User(map);
        return user;
    }

    public User query(String username) throws SQLException {
        if (username == null) {
            return null;
        }

        String sql = "SELECT * FROM consumer WHERE cname=?";
        QueryRunner qr = new QueryRunner(this.dataSource);
        Map<String, Object> map = qr.query(sql, new MapHandler(), username);

        if (map == null) {
            return null;
        }

        User user = new User(map);
        return user;
    }

    public User query(int uid) {
        return null;
    }




    public void inMoney(String username, float money) throws SQLException {
        changeMoney(username, money);
    }

    public void outMoney(String username, float money) throws SQLException {
        changeMoney(username, -money);
    }

    public void changeMoney(String username, float money) throws SQLException {
        if (username == null) {
            return;
        }

        String sql = "UPDATE consumer SET money = money + ? WHERE cname = ?";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(C3p0Utils.getConnection(),sql, money, username);
    }

    public void changeMoney(int uid, float money) throws SQLException {
        if (uid <= 0) {
            return;
        }

        String sql = "UPDATE consumer SET money = money + ? WHERE cid=?";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(C3p0Utils.getConnection(),sql, money, uid);
    }
}
