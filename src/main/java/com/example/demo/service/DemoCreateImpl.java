package com.example.demo.service;

import com.example.demo.dto.mappers.DemoMapper;
import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.exceptions.LoginExistsException;
import com.example.demo.repositories.DemoRepository;
import com.example.demo.usecase.DemoCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DemoCreateImpl implements DemoCreateUseCase {
    private final DemoRepository demoRepository;
    private final DemoMapper demoMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DemoCreateImpl(DemoRepository demoRepository, DemoMapper demoMapper,PasswordEncoder passwordEncoder) {
        this.demoRepository = demoRepository;
        this.demoMapper = demoMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DemoDtoResponse create(DemoDtoCreate dto){
        if(Boolean.TRUE.equals(demoRepository.existsByLogin(dto.getLogin()))){
            throw new LoginExistsException(dto.getLogin());
        }
        var demoEntity = demoMapper.toEntity(dto);
        demoEntity.setPassword(passwordEncoder.encode(demoEntity.getPassword()));
        return demoMapper.toDto(demoRepository.save(demoEntity));
    }
}
