package com.gal.bootcompanny.service;

import com.gal.bootcompanny.dao.EmployeeRepo;
import com.gal.bootcompanny.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }
}