package com.gal.bootcompanny.service;

import com.gal.bootcompanny.model.Department;

import java.util.List;

public interface DepartmentService {
    Department find(int id);
    List<Department> findAll();

    Department findByName(String name);

    Department addDepartment(Department dept);
}
