package com.yun11yun.dao;

import com.yun11yun.bean.User;
import org.junit.After;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao dao = new UserDao();

    @Test
    public void query() throws SQLException {
        String username01 = "wentao";
        String password01 = "123456";
        User user01 = dao.query(username01, password01);
        assertNotNull(user01);
        assertEquals(user01.getName(), username01);
        assertEquals(user01.getPassword(), password01);

        String username02 = "huang";
        User user02 = dao.query(username02,password01);
        assertNull(user02);

        String password02 = "hfioahgow";
        User user03 = dao.query(username01,password02);
        assertNull(user03);
    }

    @Test
    public void queryWithUID() throws SQLException {
        User user01 = dao.query(1);
        assertNotNull(user01);
        assertEquals("wentao", user01.getName());
        assertEquals("123456", user01.getPassword());
    }
}