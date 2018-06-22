package com.yun11yun.service;

import com.yun11yun.dao.AccountDao;
import com.yun11yun.utils.C3p0Utils;

import java.sql.SQLException;

public class AccountService {
    private AccountDao dao;

    public AccountService() {
        this.dao = new AccountDao();
    }

    public boolean checkUser(String username) {
        return false;
    }

    public boolean checkUser(int uid) {
        return false;
    }

    public void transfer(String from, String to, int money) throws SQLException {
        if (from == null || to == null) {
            return;
        }

        try {
            C3p0Utils.beginTransaction();
            dao.outMoney(from, money);
            dao.inMoney(to, money);
            C3p0Utils.commitTransaction();
        } catch (SQLException e) {
            C3p0Utils.rollbackTransaction();
            throw e;
        }
    }
}
