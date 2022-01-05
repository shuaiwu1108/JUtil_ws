package org.wslio.utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlPoolUtil {
    private MySqlPoolUtil(){}
    private static DruidDataSource druidDataSource = null;
    static {
        try {
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(FilesUtil.loadProperties("mysql.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MySqlPoolInstance{
        private static DruidPooledConnection INSTANCE;
        static {
            try {
                INSTANCE = druidDataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static DruidPooledConnection getInstance(){
        return MySqlPoolInstance.INSTANCE;
    }

    public static void close(Statement stmt, Connection conn){
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
