package com.utils;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
    public static String GetActualDate()
    {
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateAndTime.toString(formatter);
    }
}
