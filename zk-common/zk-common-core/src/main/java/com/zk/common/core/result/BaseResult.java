package com.zk.common.core.result;

import com.zk.common.core.code.CodeInterface;
import com.zk.common.core.enums.BaseCodeEnum;
import lombok.Data;

import java.beans.Transient;
import java.io.Serial;
import java.io.Serializable;

@Data
public class BaseResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private Boolean success = false;

    /**
     * 错误码 (正确码 10000)
     */
    private String code = BaseCodeEnum.ERROR.getCode();

    /**
     * 错误信息
     */
    private String message = BaseCodeEnum.ERROR.getMessage();

    public BaseResult() {

    }


    public BaseResult(boolean success) {
        if (success) {
            this.success = true;
            this.code = BaseCodeEnum.SUCCESS.getCode();
            this.message = BaseCodeEnum.SUCCESS.getMessage();
        }
    }

    public BaseResult(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BaseResult(CodeInterface code) {
        this.success = code.getCode().equals(BaseCodeEnum.SUCCESS.getCode());
        this.message = code.getMessage();
        this.code = code.getCode();
    }

    @Transient
    public boolean isNotSuccess() {
        return !success;
    }

    public boolean isSuccess() {
        return success;
    }
}