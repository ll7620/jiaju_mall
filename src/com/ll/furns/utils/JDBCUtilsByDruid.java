package com.ll.furns.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtilsByDruid {
    private static DataSource ds;
    private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<>();

    //ds初始化
    static {
        Properties properties = new Properties();
        try {
            //properties.load(new FileInputStream("src/druid.properties"));
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* public static Connection getConnection() throws SQLException {
         return ds.getConnection();
     }*/

    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocalConn.get();
        if (connection == null) {
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            threadLocalConn.set(connection);
        }
        return connection;
    }

    public static void commit() {
        Connection connection = threadLocalConn.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        threadLocalConn.remove();
    }

    public static void rollback() throws SQLException {
        Connection connection = threadLocalConn.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            threadLocalConn.remove();
        }
    }

    /*public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
