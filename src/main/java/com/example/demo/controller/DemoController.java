package com.example.demo.controller;

import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.service.DemoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping()
    public ResponseEntity<DemoDtoResponse> create(@Valid @RequestBody DemoDtoCreate demoDtoCreate){
        DemoDtoResponse demoDtoResponse = demoService.create(demoDtoCreate);
        return new ResponseEntity<>(demoDtoResponse, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemoDtoResponse> findById(@PathVariable Long id){
        DemoDtoResponse demoDtoResponse = demoService.findById(id);
        return new ResponseEntity<>(demoDtoResponse, HttpStatusCode.valueOf(200));
    }
}
