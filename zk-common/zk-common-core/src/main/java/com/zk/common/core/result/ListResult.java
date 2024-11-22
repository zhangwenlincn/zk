package com.zk.common.core.result;

import com.zk.common.core.code.CodeInterface;
import com.zk.common.core.enums.BaseCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class ListResult<T> extends BaseResult implements ResultInterface<List<T>>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 列表数据
     */
    private List<T> data;

    public ListResult() {
    }

    public ListResult(boolean success) {
        super(success);
    }

    public ListResult(CodeInterface code) {
        super(code);
    }

    public ListResult(List<T> list) {
        super(Optional.ofNullable(list).map(e -> BaseCodeEnum.SUCCESS).orElse(BaseCodeEnum.ERROR));
        this.data = list;
    }

    public ListResult(boolean success, String code, String message) {
        super(success, code, message);
    }

}