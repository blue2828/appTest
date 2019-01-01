package com.example.liuyunhuan.apptest.util;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
    public static Connection getConn () throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://123.207.98.245:3306/cSharpDb?characterEncoding=utf-8&autoReconnect=true", "root", "123456");
        return conn;
    }
    public static void closeCon (Connection conn, ResultSet rs, Object obj) {
        try {
            if (null != conn)
                conn.close();
            if (null != rs)
                rs.close();
            if (null != obj) {
                if (obj instanceof PreparedStatement)
                    ((PreparedStatement) obj).close();
                if (obj instanceof Statement)
                    ((Statement) obj).close();
            }
        }catch (Exception e) {
            Log.e("jdbcCloseErr", e.getMessage());
        }

    }
    public static void setPolicy() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
