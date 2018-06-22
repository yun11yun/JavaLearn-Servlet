package com.yun11yun.service;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServerTest {

    @Test
    public void checkUser() throws SQLException {
        UserService service = new UserService();
        assertTrue(service.checkUser("wentao","123456"));
        assertFalse(service.checkUser("wentao", "12343412"));
        assertFalse(service.checkUser("fiaoghw", "123456"));
    }
}