package com.example.demo.service;

import com.example.demo.dto.mappers.DemoMapper;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.exceptions.DemoNotFoundException;
import com.example.demo.repositories.DemoRepository;
import com.example.demo.usecase.DemoFindByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoFindByIdImpl implements DemoFindByIdUseCase {
    private final DemoRepository demoRepository;
    private final DemoMapper demoMapper;
    public DemoFindByIdImpl(DemoRepository demoRepository, DemoMapper demoMapper) {
        this.demoRepository = demoRepository;
        this.demoMapper = demoMapper;
    }

    @Override
    public DemoDtoResponse findById(Long id){
        var demoFound = demoRepository.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
        return demoMapper.toDto(demoFound);
    }
}