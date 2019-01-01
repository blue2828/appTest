package com.example.liuyunhuan.apptest.util;

import android.util.Log;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatUtil {
    public static List <Map <String, Object>> formatRsToList (ResultSet resultSet) {
        List <Map <String, Object>> resultList = new ArrayList<Map <String, Object>>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int colCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map <String, Object> tempMap = new HashMap<String, Object>();
                for (int i = 1; i <= colCount; i ++) {
                    Object tempObj = resultSet.getObject(i);
                    if (tempObj instanceof Date)
                        tempObj = StringUtil.formatDateTimeToStr((Date) tempObj, "yyyy-MM-dd HH:mm:ss");
                    tempMap.put(metaData.getColumnLabel(i), tempObj);
                }
                resultList.add(tempMap);
            }
        }catch (Exception e) {
            resultList.clear();
            Log.e("formatRsToListErr", e.getMessage());
        }
        return resultList;
    }
    /*public Object getFieldValByName (String name, Object obj) {
        Object result = null;
        String firstLetter = name.substring(0, 1).toUpperCase();
        String getter = "get".concat(firstLetter).concat(name.substring(1));
        try {
             Method method = obj.getClass().getMethod(getter, new Class [] {});
             result = method.invoke(obj, new Object[] {});
        }catch (Exception e) {
            result = null;
            Log.e("getFieldValByNameErr", e.getMessage());
        }
        return result;
    }
    public String[] getFieldName () {
        String[] fields = new String[] {};

        return fields;
    }*/
}
