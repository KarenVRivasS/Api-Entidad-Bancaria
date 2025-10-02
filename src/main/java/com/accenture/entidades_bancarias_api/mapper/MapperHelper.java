package com.accenture.entidades_bancarias_api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class MapperHelper {


    private final ModelMapper modelMapper;

    private static MapperHelper mapper = null;

    public MapperHelper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static  MapperHelper instance() {
        if (mapper == null) {

            mapper = ContextProvider.getApplicationContext().getBean(MapperHelper.class);
        }

        return mapper;
    }

    public <T> T convertToEntity(Object dto, Class entityClass) {

        return (T) modelMapper.map(dto, entityClass);
    }

    public <T> T convertToDto(Object o, Class dtoClass) {

        return (T) modelMapper.map(o, dtoClass);
    }

}
