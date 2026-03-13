package com.gal.bootcompanny.service;

import com.gal.bootcompanny.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department find(int id);
    public List<Department> findAll();
}
