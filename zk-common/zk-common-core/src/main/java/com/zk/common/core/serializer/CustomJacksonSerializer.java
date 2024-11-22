package com.zk.common.core.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zk.common.core.constant.Constants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomJacksonSerializer {


    /**
     * 时间格式化
     */
    public static final JsonSerializer<Date> DATE_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(Constants.DATE_FORMAT.format(value));
        }
    };

    /**
     * Long转String
     */
    public static final JsonSerializer<java.lang.Long> LONG_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(String.valueOf(value));
        }
    };

    /**
     * Year转String
     */
    public static final JsonSerializer<java.time.Year> YEAR_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.Year value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(Constants.YEAR_FORMATTER));
        }
    };

    /**
     * YearMonth转String
     */
    public static final JsonSerializer<java.time.YearMonth> YEAR_MONTH_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.YearMonth value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(Constants.YEAR_MONTH_FORMATTER));
        }
    };
    /**
     * MonthDay转String
     */
    public static final JsonSerializer<java.time.MonthDay> MONTH_DAY_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.MonthDay value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(Constants.MONTH_DAY_FORMATTER));
        }
    };


    /**
     * LocalDate转String
     */
    public static final JsonSerializer<java.time.LocalDate> LOCAL_DATE_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(Constants.LOCAL_DATE_FORMATTER));
        }
    };

    /**
     * LocalDateTime转String
     */
    public static final JsonSerializer<java.time.LocalDateTime> LOCAL_DATE_TIME_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(Constants.LOCAL_DATE_TIME_FORMATTER));
        }
    };
    /**
     * LocalTime转String
     */
    public static final JsonSerializer<java.time.LocalTime> LOCAL_TIME_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.LocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(Constants.LOCAL_TIME_FORMATTER));
        }
    };
}
