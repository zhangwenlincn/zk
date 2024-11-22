package com.zk.common.core.result;

import com.zk.common.core.code.CodeInterface;
import com.zk.common.core.enums.BaseCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectResult<T> extends BaseResult implements ResultInterface<T>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 业务数据
     */
    private T data;

    public ObjectResult() {
    }

    public ObjectResult(boolean success) {
        super(success);
    }

    public ObjectResult(CodeInterface code) {
        super(code);
    }

    public ObjectResult(T t) {
        super(Optional.ofNullable(t).map(e -> BaseCodeEnum.SUCCESS).orElse(BaseCodeEnum.ERROR));
        this.data = t;
    }

    public ObjectResult(boolean success, String code, String message) {
        super(success, code, message);
    }
}