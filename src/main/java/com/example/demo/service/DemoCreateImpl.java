package com.example.demo.service;

import com.example.demo.dto.mappers.DemoMapper;
import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.exceptions.LoginExistsException;
import com.example.demo.repositories.DemoRepository;
import com.example.demo.usecase.DemoCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoCreateImpl implements DemoCreateUseCase {
    private final DemoRepository demoRepository;
    private final DemoMapper demoMapper;

    @Autowired
    public DemoCreateImpl(DemoRepository demoRepository, DemoMapper demoMapper) {
        this.demoRepository = demoRepository;
        this.demoMapper = demoMapper;
    }

    @Override
    public DemoDtoResponse create(DemoDtoCreate dto){
        if(Boolean.TRUE.equals(demoRepository.existsByLogin(dto.getLogin()))){
            throw new LoginExistsException(dto.getLogin());
        }
        return demoMapper.toDto(demoRepository.save(demoMapper.toEntity(dto)));
    }
}
