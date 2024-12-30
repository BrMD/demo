package com.example.demo.usecase;

import com.example.demo.dto.response.DemoDtoResponse;

public interface DemoFindByIdUseCase {
    DemoDtoResponse findById(Long id);
}
