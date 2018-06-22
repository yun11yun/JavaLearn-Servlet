package com.yun11yun.dao;

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SearchDaoTest {

    private SearchDao dao = new SearchDao();

    @Test
    public void searchKeysWith() throws SQLException {
        List<String> list = dao.searchKeysWith("a");
        assertTrue(list.size() > 0);
    }
}