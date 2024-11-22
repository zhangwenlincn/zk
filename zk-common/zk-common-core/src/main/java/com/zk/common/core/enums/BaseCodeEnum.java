package com.zk.common.core.enums;

import com.zk.common.core.code.CodeInterface;
import lombok.Getter;

@Getter
public enum BaseCodeEnum implements CodeInterface {

    SUCCESS("10000", "操作成功"),
    ERROR("10001", "操作失败"),
    EXCEPTION_FAIL("10002", "操作异常"),
    JACKSON_CONVERT_FAIL("10003", "JSON转换异常"),

    ;

    private final String code;

    private final String message;

    BaseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
