package com.zk.common.core.constant;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Constants {

    public static final String STR_LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String STR_LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    public static final String STR_LOCAL_TIME_FORMAT = "HH:mm:ss";

    public static final String STR_YEAR_FORMAT = "yyyy";

    public static final String STR_YEAR_MONTH_FORMAT = "yyyy-MM";

    public static final String STR_MONTH_DAY_FORMAT = "MM-dd";

    public static final String STR_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern(Constants.STR_YEAR_FORMAT);

    public static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern(Constants.STR_YEAR_MONTH_FORMAT);

    public static final DateTimeFormatter MONTH_DAY_FORMATTER = DateTimeFormatter.ofPattern(Constants.STR_MONTH_DAY_FORMAT);

    public static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(Constants.STR_LOCAL_DATE_FORMAT);

    public static final DateTimeFormatter LOCAL_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.STR_LOCAL_TIME_FORMAT);

    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.STR_LOCAL_DATE_TIME_FORMAT);

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(Constants.STR_DATE_FORMAT);
}
