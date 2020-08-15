package com.wincentzzz.project.template.springhack.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String toDateString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");

        return simpleDateFormat.format(date);
    }
}
