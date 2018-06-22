package com.yun11yun.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class C3p0Utils {

    private C3p0Utils() {}

    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal <>();

    public static Connection getConnection() {
        try {
            Connection connection = threadLocal.get();
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("服务器错误");
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        C3p0Utils.dataSource = dataSource;
    }

    public static void release(Connection conn, Statement statement, ResultSet set) {
        release(conn);
        release(statement);
        release(set);
    }

    public static void beginTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        connection.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        connection.commit();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        connection.rollback();
    }

    public static void release(AutoCloseable obj) {
        if (obj == null) {
            return;
        }

        try {
            obj.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
