package com.example.demo.usecase;

import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import org.springframework.stereotype.Service;


public interface DemoCreateUseCase {
    DemoDtoResponse create(DemoDtoCreate dto);
}
