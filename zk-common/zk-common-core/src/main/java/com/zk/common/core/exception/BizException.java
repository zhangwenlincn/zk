package com.zk.common.core.exception;

import com.zk.common.core.code.CodeInterface;
import com.zk.common.core.enums.BaseCodeEnum;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    private final String code;

    private final String message;

    private Throwable e;

    public BizException(CodeInterface baseEnum) {
        super(baseEnum.getMessage());
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }

    public BizException(CodeInterface baseEnum, Throwable e) {
        super(baseEnum.getMessage(), e);
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
        this.e = e;
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
        this.message = message;
        this.e = e;
    }

    public BizException(String message) {
        super(message);
        this.code = BaseCodeEnum.EXCEPTION_FAIL.getCode();
        this.message = message;
    }

    public BizException(String message, Throwable e) {
        super(message, e);
        this.code = BaseCodeEnum.EXCEPTION_FAIL.getCode();
        this.message = message;
        this.e = e;
    }

    public BizException(Throwable e) {
        super(BaseCodeEnum.EXCEPTION_FAIL.getMessage(), e);
        this.code = BaseCodeEnum.EXCEPTION_FAIL.getCode();
        this.message = BaseCodeEnum.EXCEPTION_FAIL.getMessage();
        this.e = e;
    }
}
