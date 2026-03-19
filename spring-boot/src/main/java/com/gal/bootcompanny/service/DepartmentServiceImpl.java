package com.gal.bootcompanny.service;

import com.gal.bootcompanny.dao.DepartmentDao;
import com.gal.bootcompanny.dao.DepartmentRepository;
import com.gal.bootcompanny.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);


    @Autowired
    DepartmentRepository repo;
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

    public Department findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Department addDepartment(Department dept) {
        repo.save(dept);
        log.debug("service returning " + dept);
        return dept;
    }
}
