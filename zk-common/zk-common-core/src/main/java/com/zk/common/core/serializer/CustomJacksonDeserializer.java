package com.zk.common.core.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.zk.common.core.constant.Constants;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CustomJacksonDeserializer {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期反序列化
     */
    public static final JsonDeserializer<java.util.Date> DATE_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            try {
                return dateFormat.parse(jsonParser.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    };
    /**
     * 年份反序列化
     */
    public static final JsonDeserializer<java.time.Year> YEAR_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.Year deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.Year.parse(jsonParser.getText(), Constants.YEAR_FORMATTER);
        }
    };

    /**
     * 年月反序列化
     */
    public static final JsonDeserializer<java.time.YearMonth> YEAR_MONTH_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.YearMonth deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.YearMonth.parse(jsonParser.getText(), Constants.YEAR_MONTH_FORMATTER);
        }
    };
    /**
     * 月日反序列化
     */
    public static final JsonDeserializer<java.time.MonthDay> MONTH_DAY_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.MonthDay deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.MonthDay.parse(jsonParser.getText(), Constants.MONTH_DAY_FORMATTER);
        }
    };


    /**
     * LocalDate反序列化
     */
    public static final JsonDeserializer<LocalDate> LOCAL_DATE_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(jsonParser.getText(), Constants.LOCAL_DATE_FORMATTER);
        }
    };
    /**
     * LocalDateTime反序列化
     */
    public static final JsonDeserializer<java.time.LocalDateTime> LOCAL_DATE_TIME_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.LocalDateTime.parse(jsonParser.getText(), Constants.LOCAL_DATE_TIME_FORMATTER);
        }
    };
    /**
     * LocalTime反序列化
     */
    public static final JsonDeserializer<java.time.LocalTime> LOCAL_TIME_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.LocalTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.LocalTime.parse(jsonParser.getText(), Constants.LOCAL_TIME_FORMATTER);
        }
    };
}
