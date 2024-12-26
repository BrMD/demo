package com.example.demo.dto.mappers;

import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.entities.DemoEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoMapper {
    public DemoDtoResponse toDto(DemoEntity demoEntity){
        if(demoEntity == null) return null;
        return new DemoDtoResponse(demoEntity.getId(), demoEntity.getLogin(), demoEntity.getPassword());
    }

    public DemoEntity toEntity(DemoDtoResponse demoDtoResponse){
        if(demoDtoResponse == null) return null;
        return new DemoEntity(demoDtoResponse.getId(), demoDtoResponse.getLogin(), demoDtoResponse.getPassword());
    }

    public DemoEntity toEntity(DemoDtoCreate demoDtoCreate){
        if(demoDtoCreate == null) return null;
        return new DemoEntity(demoDtoCreate.getLogin(), demoDtoCreate.getPassword());
    }
}
