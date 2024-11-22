package com.zk.common.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zk.common.core.enums.BaseCodeEnum;
import com.zk.common.core.enums.JacksonEnum;
import com.zk.common.core.exception.BizException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JacksonUtil {

    public static ObjectMapper getObjectMapper() {
        return JacksonEnum.INSTANCE.getInstance().getObjectMapper();
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new BizException(BaseCodeEnum.JACKSON_CONVERT_FAIL, e);
        }
    }

    public static Map<String, Object> toMap(String json) {
        try {
            return getObjectMapper().readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new BizException(BaseCodeEnum.JACKSON_CONVERT_FAIL, e);
        }
    }

    public static <T> List<T> toList(String json) {
        try {
            return getObjectMapper().readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new BizException(BaseCodeEnum.JACKSON_CONVERT_FAIL, e);
        }
    }

    public static <T> String toJson(T t) {
        ObjectMapper objectMapper = getObjectMapper();
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new BizException(BaseCodeEnum.JACKSON_CONVERT_FAIL, e);
        }
    }

    /**
     * 过滤掉指定字段，并返回json字符串
     *
     * @param t             source object
     * @param excludeFields exclude fields
     * @param <T>           T
     * @return json string
     */
    public static <T> String toJsonExclude(T t, List<String> excludeFields) {
        ObjectNode objectNode = JacksonUtil.toObjectNode(JacksonUtil.toJson(t));
        return toJson(filter(objectNode, excludeFields));
    }

    /**
     * 过滤出指定字段，并返回json字符串
     *
     * @param t             source object
     * @param includeFields exclude fields
     * @param <T>           T
     * @return json string
     */
    public static <T> String toJsonInclude(T t, List<String> includeFields) {
        ObjectNode objectNode = JacksonUtil.toObjectNode(JacksonUtil.toJson(t));
        List<String> excludeFields = new ArrayList<>();
        objectNode.fieldNames().forEachRemaining(field -> {
            if (!includeFields.contains(field)) {
                excludeFields.add(field);
            }
        });
        return toJson(filter(objectNode, excludeFields));
    }


    public static ObjectNode filter(ObjectNode objectNode, List<String> excludeFields) {
        if (excludeFields != null && !excludeFields.isEmpty()) {
            excludeFields.forEach(objectNode::remove);
        }
        return objectNode;
    }

    public static JsonNode toJsonNode(String json) {
        try {
            return getObjectMapper().readTree(json);
        } catch (JsonProcessingException e) {
            throw new BizException(BaseCodeEnum.JACKSON_CONVERT_FAIL, e);
        }
    }

    public static ObjectNode toObjectNode(String json) {
        try {
            return (ObjectNode) getObjectMapper().readTree(json);
        } catch (JsonProcessingException e) {
            throw new BizException(BaseCodeEnum.JACKSON_CONVERT_FAIL, e);
        }
    }
}
