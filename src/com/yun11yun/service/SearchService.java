package com.yun11yun.service;

import com.yun11yun.dao.SearchDao;

import java.sql.SQLException;
import java.util.List;

public class SearchService {

    private SearchDao dao;

    public SearchService() {
        this.dao = new SearchDao();
    }

    public List<String> searchKeysWith(String s) throws SQLException {
        if (s == null) {
            return null;
        }

        return this.dao.searchKeysWith(s);
    }
}
