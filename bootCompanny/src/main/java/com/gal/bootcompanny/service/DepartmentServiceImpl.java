package com.gal.bootcompanny.service;

import com.gal.bootcompanny.dao.DepartmentDao;
import com.gal.bootcompanny.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    DepartmentDao departmentDao;
    @Autowired
    public DepartmentServiceImpl(DepartmentDao d) {
        this.departmentDao = d;
    }
    @Override
    public Department find(int id) {
        return departmentDao.find(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
