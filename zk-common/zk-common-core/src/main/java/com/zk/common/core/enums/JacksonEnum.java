package com.zk.common.core.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zk.common.core.serializer.CustomJacksonDeserializer;
import com.zk.common.core.serializer.CustomJacksonSerializer;
import lombok.Getter;

@Getter
public enum JacksonEnum {


    INSTANCE;

    private final ObjectMapper objectMapper;

    JacksonEnum() {
        this.objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        //序列化设置

        simpleModule.addSerializer(java.lang.Long.class, CustomJacksonSerializer.LONG_SERIALIZER);
        simpleModule.addSerializer(java.util.Date.class, CustomJacksonSerializer.DATE_SERIALIZER);

        simpleModule.addSerializer(java.time.Year.class, CustomJacksonSerializer.YEAR_SERIALIZER);
        simpleModule.addSerializer(java.time.YearMonth.class, CustomJacksonSerializer.YEAR_MONTH_SERIALIZER);
        simpleModule.addSerializer(java.time.MonthDay.class, CustomJacksonSerializer.MONTH_DAY_SERIALIZER);

        simpleModule.addSerializer(java.time.LocalDate.class, CustomJacksonSerializer.LOCAL_DATE_SERIALIZER);
        simpleModule.addSerializer(java.time.LocalDateTime.class, CustomJacksonSerializer.LOCAL_DATE_TIME_SERIALIZER);
        simpleModule.addSerializer(java.time.LocalTime.class, CustomJacksonSerializer.LOCAL_TIME_SERIALIZER);


        //反序列化设置
        simpleModule.addDeserializer(java.util.Date.class, CustomJacksonDeserializer.DATE_DESERIALIZER);

        simpleModule.addDeserializer(java.time.Year.class, CustomJacksonDeserializer.YEAR_DESERIALIZER);
        simpleModule.addDeserializer(java.time.YearMonth.class, CustomJacksonDeserializer.YEAR_MONTH_DESERIALIZER);
        simpleModule.addDeserializer(java.time.MonthDay.class, CustomJacksonDeserializer.MONTH_DAY_DESERIALIZER);

        simpleModule.addDeserializer(java.time.LocalDate.class, CustomJacksonDeserializer.LOCAL_DATE_DESERIALIZER);
        simpleModule.addDeserializer(java.time.LocalDateTime.class, CustomJacksonDeserializer.LOCAL_DATE_TIME_DESERIALIZER);
        simpleModule.addDeserializer(java.time.LocalTime.class, CustomJacksonDeserializer.LOCAL_TIME_DESERIALIZER);

        objectMapper.registerModule(simpleModule);
    }

    public JacksonEnum getInstance() {
        return INSTANCE;
    }

}