package com.example.liuyunhuan.apptest.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    public static boolean isEmpty (String str) {
        if (null == str || "".equals(str))
            return true;
        else
            return false;
    }
    public static String formatDateTimeToStr (Date date, String str) {
        String returnStr = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            returnStr = simpleDateFormat.format(date);
        }catch (Exception e) {
            returnStr = "";
            Log.e("dateFormatErr", e.getMessage());
        }
        return returnStr;
    }
}
