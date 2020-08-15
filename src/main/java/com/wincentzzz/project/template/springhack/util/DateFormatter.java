package com.wincentzzz.project.template.springhack.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateFormatter {
    public static String toDateString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");

        return simpleDateFormat.format(date);
    }

    public static Integer getMonth(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getMonthValue();
    }
}
