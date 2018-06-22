package com.yun11yun.dao;

import com.yun11yun.bean.User;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class AccountDaoTest {

    private AccountDao dao = new AccountDao();

    @Test
    public void testQuery() throws SQLException {
        User user = dao.query("wentao", "123456");
        assertNotNull(user);
        assertEquals("wentao", user.getName());
        assertEquals("123456", user.getPassword());
    }

}