package com.yun11yun.service;

import com.yun11yun.bean.User;
import com.yun11yun.dao.AccountDao;
import com.yun11yun.utils.C3p0Utils;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AccountServiceTest {

    private AccountService service = new AccountService();
    private AccountDao dao = new AccountDao();

    @Test
    public void checkUser() {
    }

    @Test
    public void checkUser1() {
    }

    @Test
    public void transfer() throws SQLException {

        User originWenmin = dao.query("wenmin");
        User originWentao = dao.query("wentao");

        service.transfer("wenmin", "wentao", 3000);

        User wenmin = dao.query("wenmin");
        User wentao = dao.query("wentao");

        assertEquals(wenmin.getMoney() - originWenmin.getMoney(), -3000, 0.1);
        assertEquals(wentao.getMoney() - originWentao.getMoney(), 3000, 0.1);
    }
}