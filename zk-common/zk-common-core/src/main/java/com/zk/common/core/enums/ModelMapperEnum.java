package com.zk.common.core.enums;

import lombok.Getter;
import org.modelmapper.ModelMapper;

@Getter
public enum ModelMapperEnum {

    INSTANCE;

    private final ModelMapper modelMapper;

    ModelMapperEnum() {
        this.modelMapper = new ModelMapper();
    }

    public ModelMapperEnum getInstance() {
        return INSTANCE;
    }
}
