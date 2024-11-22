package com.zk.common.core.result;

public interface ResultInterface<T> {
    String getCode();

    boolean isSuccess();

    String getMessage();

    T getData();
}
