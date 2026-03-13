package com.gal.bootcompanny.dao;

import com.gal.bootcompanny.model.Department;

import java.util.List;

public interface DepartmentDao {
    Department find(int id);
    List<Department> findAll();
}
