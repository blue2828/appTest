package com.example.liuyunhuan.apptest.service;

import android.util.Log;

import com.example.liuyunhuan.apptest.util.FormatUtil;
import com.example.liuyunhuan.apptest.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InfoService {
    private PreparedStatement pstm = null;
    private ResultSet rs;
    private Connection conn;
    public List <Map <String, Object>> getInfo (int infoId) {
        List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
        StringBuffer sql = new StringBuffer ("SELECT i.ID infoId, i.heighth, i.count, i.single, i.total, i.time AS info_time, c.colorName, p.providerName, " +
                "p.address, p.phone, p.linkman, lo.locationInfo, s.symbol FROM info i LEFT JOIN color c ON i.`colorID` = c.`colorID`" +
                " LEFT JOIN provider p ON i.`providerID` = p.providerID LEFT JOIN location lo ON i.`locationID` = lo.locationID " +
                "LEFT JOIN symbol s ON i.`symbol` = s.`number`");
        if (infoId != -1)
            sql.append("  WHERE i.ID = ?");
        try {
            conn = JdbcUtil.getConn();
            pstm = conn.prepareStatement(sql.toString());
            if (infoId != -1)
                pstm.setInt(1, infoId);
            rs = pstm.executeQuery();
            list = FormatUtil.formatRsToList(rs);
        }catch (Exception e) {
            Log.e("getInfoErr", e.getMessage());
        }finally {
            try {
                JdbcUtil.closeCon(conn, rs, pstm);
            }catch (Exception e) {
                Log.e("closeConErr", e.getMessage());
            }
        }
        return list;
    }
    public List <Map <String, Object>> getInInfo (int id) {
        List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
        StringBuffer sql = new StringBuffer ("SELECT i.ID, i.time, s.symbol FROM info_in AS i JOIN symbol s ON i.`symbol` = s.`number`");
        if (id != -1)
            sql.append("  WHERE i.ID = ?");
        try {
            conn = JdbcUtil.getConn();
            pstm = conn.prepareStatement(sql.toString());
            if (id != -1)
                pstm.setInt(1, id);
            rs = pstm.executeQuery();
            list = FormatUtil.formatRsToList(rs);
        }catch (Exception e) {
            Log.e("getInfoErr", e.getMessage());
        }finally {
            try {
                JdbcUtil.closeCon(conn, rs, pstm);
            }catch (Exception e) {
                Log.e("closeConErr", e.getMessage());
            }
        }
        return list;
    }
    public List <Map <String, Object>> getOutInfo () {
        List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
        StringBuffer sql = new StringBuffer ("SELECT o.ID, o.time, s.symbol FROM info_out AS o JOIN symbol s ON o.`symbol` = s.`number`");
        try {
            conn = JdbcUtil.getConn();
            pstm = conn.prepareStatement(sql.toString());
            rs = pstm.executeQuery();
            list = FormatUtil.formatRsToList(rs);
        }catch (Exception e) {
            Log.e("getInfoErr", e.getMessage());
        }finally {
            try {
                JdbcUtil.closeCon(conn, rs, pstm);
            }catch (Exception e) {
                Log.e("closeConErr", e.getMessage());
            }
        }
        return list;
    }
}
