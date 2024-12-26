package com.example.demo.service;

import com.example.demo.dto.mappers.DemoMapper;
import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.exceptions.DemoNotFoundException;
import com.example.demo.repositories.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;
    @Autowired
    private DemoMapper demoMapper;

    public DemoDtoResponse create(DemoDtoCreate dto){
       return demoMapper.toDto(demoRepository.save(demoMapper.toEntity(dto))) ;
    }

    public DemoDtoResponse findById(Long id){
        var demoFound = demoRepository.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
        return demoMapper.toDto(demoFound);
    }
}
