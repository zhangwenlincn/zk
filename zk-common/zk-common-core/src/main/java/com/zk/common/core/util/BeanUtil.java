package com.zk.common.core.util;

import com.zk.common.core.enums.ModelMapperEnum;
import org.modelmapper.ModelMapper;

import java.util.List;

public class BeanUtil {
    public static ModelMapper getInstance() {
        return ModelMapperEnum.INSTANCE.getInstance().getModelMapper();
    }


    public static <T> T copy(Object source, Class<T> targetClass) {
        return BeanUtil.getInstance().map(source, targetClass);
    }

    public static <T> List<T> copyList(List<Object> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(source -> copy(source, targetClass)).toList();
    }
}
