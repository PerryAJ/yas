package com.yas.commonlibrary.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

// TODO: add java docs
public interface BaseMapper<Model, ViewModel> {

    Model toModel(ViewModel vm);

    ViewModel toVm(Model model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Model model, ViewModel viewModel);

}
