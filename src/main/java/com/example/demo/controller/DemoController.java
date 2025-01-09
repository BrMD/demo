package com.example.demo.controller;

import com.example.demo.dto.request.DemoDtoCreate;
import com.example.demo.dto.response.DemoDtoResponse;
import com.example.demo.service.DemoCreateImpl;
import com.example.demo.service.DemoFindByIdImpl;
import com.example.demo.service.JavaMailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoCreateImpl demoCreateImpl;
    private final DemoFindByIdImpl demoFindByIdImpl;
    private final JavaMailService javaMailService;

    public DemoController(DemoCreateImpl demoCreateImpl,DemoFindByIdImpl demoFindByIdImpl,JavaMailService javaMailService) {
        this.demoCreateImpl = demoCreateImpl;
        this.demoFindByIdImpl = demoFindByIdImpl;
        this.javaMailService = javaMailService;
    }

    @PostMapping()
    public ResponseEntity<DemoDtoResponse> create(@Valid @RequestBody DemoDtoCreate demoDtoCreate){
        DemoDtoResponse demoDtoResponse = demoCreateImpl.create(demoDtoCreate);
        return new ResponseEntity<>(demoDtoResponse, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemoDtoResponse> findById(@PathVariable Long id){
        DemoDtoResponse demoDtoResponse = demoFindByIdImpl.findById(id);
        return new ResponseEntity<>(demoDtoResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/testeemail")
    public ResponseEntity<String> emailteste(){
        javaMailService.enviar();
        return new ResponseEntity<>("a", HttpStatusCode.valueOf(200));
    }
}
