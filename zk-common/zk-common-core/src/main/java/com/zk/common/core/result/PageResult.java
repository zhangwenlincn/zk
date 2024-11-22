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
public class PageResult<T> extends BaseResult implements ResultInterface<List<T>>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分页信息
     */
    private Pager page;

    /**
     * 页码对应数据
     */
    private List<T> data;

    public PageResult() {
    }

    public PageResult(Boolean success) {
        super(success);
    }

    public PageResult(CodeInterface code) {
        super(code);
    }

    public PageResult(Boolean success, String code, String message) {
        super(success, code, message);
    }

    public PageResult(Pager pager, List<T> list) {
        super(Optional.ofNullable(list).map(e -> BaseCodeEnum.SUCCESS).orElse(BaseCodeEnum.ERROR));
        this.page = pager;
        this.data = list;
    }


}