package com.zhou.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_STRING = "1999-01-01 00:00:00";

    public static Date createDefaultDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        Date defaultDate = null;
        try {
            defaultDate = sdf.parse(DEFAULT_DATE_STRING);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return defaultDate;
    }

    public static void main(String[] args) {
        Date date = createDefaultDate();
        System.out.println("date:" + date);
    }
}
