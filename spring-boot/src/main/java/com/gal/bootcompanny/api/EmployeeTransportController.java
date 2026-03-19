package com.gal.bootcompanny.api;

import com.gal.bootcompanny.model.EmployeeTransportDTO;
import com.gal.bootcompanny.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeTransportController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeTransportDTO> getAll(){
        return service.getAllEmployee().stream()
                .map(EmployeeTransportDTO::new)
                .collect(Collectors.toList());
    }
}