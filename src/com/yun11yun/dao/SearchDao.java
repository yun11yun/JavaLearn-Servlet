package com.yun11yun.dao;

import com.yun11yun.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchDao {

    public List<String> searchKeysWith(String s) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "SELECT * FROM search WHERE `key` LIKE ? limit 5";

        String param = "%" + s + "%";
        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), param);

        List<String> keys = new ArrayList <>();
        for (Map <String, Object> map : mapList) {
            keys.add((String)map.get("key"));
        }

        if (keys.size() > 0) {
            return keys;
        }

        return null;
    }
}
