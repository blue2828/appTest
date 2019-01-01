package com.example.liuyunhuan.apptest.service;

import com.example.liuyunhuan.apptest.entity.User;
import com.example.liuyunhuan.apptest.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
    private Connection connection = null;
    private ResultSet rs = null;
    private PreparedStatement pstm = null;
    public boolean checkLogin (User user) {
        boolean isPassed = false;
        try {
            connection = JdbcUtil.getConn();
            pstm = connection.prepareStatement("select * from admin where username = ? and password = ?");
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPwd());
            rs = pstm.executeQuery();
            isPassed = rs.next() ? true : false;
        }catch (Exception e) {
            isPassed = false;
            e.printStackTrace();
        }finally {
            JdbcUtil.closeCon(connection, rs, pstm);
        }
        return isPassed;
    }
}
