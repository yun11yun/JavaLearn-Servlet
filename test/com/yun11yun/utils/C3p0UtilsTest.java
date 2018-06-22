package com.yun11yun.utils;

import com.yun11yun.bean.User;
import com.yun11yun.dao.AccountDao;
import org.junit.Test;

import java.sql.SQLException;
import static org.junit.Assert.*;

public class C3p0UtilsTest {

    private AccountDao dao = new AccountDao();

    @Test
    public void transactionTest() throws SQLException {
        try {

            User originWenmin = dao.query("wenmin");
            User originWentao = dao.query("wentao");

            C3p0Utils.beginTransaction();
            dao.outMoney("wenmin", 2000);
            dao.inMoney("wentao", 2000);
            C3p0Utils.commitTransaction();

            User wenmin = dao.query("wenmin");
            User wentao = dao.query("wentao");

            assertEquals(wenmin.getMoney() - originWenmin.getMoney(), -2000, 0.1);
            assertEquals(wentao.getMoney() - originWentao.getMoney(), 2000, 0.1);
        } catch (Exception e) {
            try {
                C3p0Utils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Test
    public void transactionWhenHaveException() throws SQLException {

        User originWenmin = dao.query("wenmin");
        User originWentao = dao.query("wentao");

        try {
            C3p0Utils.beginTransaction();
            dao.outMoney("wenmin", 2000);
            int some = 3 / 0;
            dao.inMoney("wentao", 2000);
            C3p0Utils.commitTransaction();
        } catch (Exception e) {
            try {
                C3p0Utils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        User wenmin = dao.query("wenmin");
        User wentao = dao.query("wentao");

        assertEquals(wenmin.getMoney() - originWenmin.getMoney(), 0, 0.1);
        assertEquals(wentao.getMoney() - originWentao.getMoney(), 0, 0.1);
    }

    @Test
    public void testAnd() {
        int a = 0b1001;
        int b = 0b1011;
        
        System.out.println(Math.pow(16,8));

        assertEquals(0b1001, a & b);
    }
}